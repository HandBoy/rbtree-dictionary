package arvore;

import utils.Nill;
import utils.Node;

public class RBTreeDictionary {
	private Node raiz;
	private int tamanho;
	private Node nill;	
	
	
	public RBTreeDictionary() {
		super();
		this.nill = new Nill();
		this.raiz = nill;
	}
	public Node getRaiz() {
		return raiz;
	}
	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public void growUp(){
		this.tamanho++;
	}
	public Node getNill() {
		return nill;
	}
	public void setNill(Node nill) {
		this.nill = nill;
	}
	
	
	
}
