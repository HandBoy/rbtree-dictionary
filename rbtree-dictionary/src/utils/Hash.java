package utils;

public class Hash {
	public static int hash(String palavra){
		int cont = 0;
		for (int i = 0; i < palavra.length(); i++) {
			cont += palavra.codePointAt(i) * i;
		}
		return cont;
	}
}
