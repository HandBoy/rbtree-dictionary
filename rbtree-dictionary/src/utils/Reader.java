package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public static List<Node> lerArquivo(File arquivo){
		List<Node> palavras = new ArrayList<Node>();
		try {
			if (arquivo.exists()) {		
				FileReader fr = new FileReader(arquivo);		//faz a leitura do arquivo				
				BufferedReader br = new BufferedReader(fr);
				//equanto houver mais linhas
				String linha;
				while (br.ready()) {				
					linha = br.readLine().trim();						//lê a proxima linha	
					if(!linha.isEmpty() && linha.length() < 20 ){
						Node palavra = new Node(linha.substring(0, linha.length()-1).trim());
						int acao =  Character.getNumericValue(linha.charAt(linha.length()-1));
						palavra.setAcao(acao);
						palavras.add(palavra);
					}
				}

				br.close();
				fr.close();
				System.out.println("Leitura do Arquivo Finalizada"); 
				System.out.println("=========================================== \n");
				return palavras;
			} else {
				return null;
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
