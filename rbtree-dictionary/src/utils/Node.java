package utils;

public class Node {
	private Node pai;
	private Node esquerda;
	private Node direita;
	private Node cor;
	
	public Node getPai() {
		return pai;
	}
	public void setPai(Node pai) {
		this.pai = pai;
	}
	public Node getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}
	public Node getDireita() {
		return direita;
	}
	public void setDireita(Node direita) {
		this.direita = direita;
	}
	public Node getCor() {
		return cor;
	}
	public void setCor(Node cor) {
		this.cor = cor;
	}
	
	
}
