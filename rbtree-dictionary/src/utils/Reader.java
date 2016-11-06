package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public static List<Node> lerArquivo(String arq){
		List<Node> palavras = new ArrayList<Node>();
		
		File arquivo = new File(arq);

		try {
			System.out.println(arquivo.getAbsolutePath());
			if (arquivo.exists()) {		

				FileReader fr = new FileReader(arquivo);		//faz a leitura do arquivo
				
				BufferedReader br = new BufferedReader(fr);

				//equanto houver mais linhas
				String linha;
				while (br.ready()) {				
					linha = br.readLine().trim();						//lê a proxima linha	
					//System.out.println(linha.substring(0, linha.length()-1));
					//System.out.println(linha.charAt(linha.length()-1));
					Node palavra = new Node(linha.substring(0, linha.length()-1));
					palavra.setAcao(linha.charAt(linha.length()-1));
					palavras.add(palavra);
				}

				br.close();
				fr.close();
				
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
