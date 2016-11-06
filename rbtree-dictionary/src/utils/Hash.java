package utils;

public class Hash {
	public static int hash(String palavra){
		int hash = 0;
		for (int i = 0; i < palavra.length(); i++) {
			hash += palavra.codePointAt(i) * i;
		}
		return hash;
	}
}
