import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import utils.Reader;

public class Start {

	public static void main(String[] args) {

		System.out.println("Procurando Arquivo");
		
		List<String> palavras = Reader.lerArquivo(args[0]);
		if(palavras == null)
			System.out.println("Arquivo Não Encontrado");
		else
			System.out.println("Arquivo  Encontrado");
		
		

	}

}
