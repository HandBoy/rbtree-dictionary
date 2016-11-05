package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public static List<String> lerArquivo(String arq){
		List<String> palavras = new ArrayList<String>();
		
		File arquivo = new File(arq);

		try {
			System.out.println(arquivo.getAbsolutePath());
			if (arquivo.exists()) {		

				FileReader fr = new FileReader(arquivo);		//faz a leitura do arquivo
				
				BufferedReader br = new BufferedReader(fr);

				//equanto houver mais linhas
				String linha;
				while (br.ready()) {				
					linha = br.readLine();						//lê a proxima linha				
					palavras.add(linha);
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
