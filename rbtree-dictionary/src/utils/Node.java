package utils;

public class Node {
	protected Node pai;
	protected Node esquerda;
	protected Node direita;
	protected String cor;
	protected int chave;
	protected String palavra;
	protected int acao;	

	public Node(String palavra) {
		super();
		this.pai = null;
		this.esquerda = null;
		this.direita = null;
		this.cor = "red";
		this.palavra = palavra;
		this.chave = Hash.hash(palavra);		
	}
	
	public Node() {
		super();		
	}
	
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
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
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	
	public int getAcao() {
		return acao;
	}
	public void setAcao(int acao) {
		this.acao = acao;
	}
	public String details(){

		StringBuilder stBuilder = new StringBuilder();
		if(this.getPai() instanceof Nill ){
			stBuilder.append("Pai: NULL "); 
		} else {
			stBuilder.append("Pai: " + this.getPai().getPalavra()); 
		}	

		stBuilder.append(" Palavra: " + this.palavra );
		stBuilder.append(" Chave: " + this.chave );		
		stBuilder.append(" Cor: " + this.cor );
		
		if(this.getEsquerda() == null ){
			stBuilder.append(" FilhoEsq: NULL "); 
		} else {
			stBuilder.append(" FilhoEsq: " + this.getEsquerda().getPalavra()+ " " + this.getEsquerda().getChave()); 
		}
		
		if(this.getDireita() == null ){
			stBuilder.append(" FilhoDir: NULL "); 
		} else {
			stBuilder.append(" FilhoDir: " + this.getDireita().getPalavra()+ " "  + this.getDireita().getChave()); 
		}
		
		return stBuilder.toString();
		
	}
	
	public String toString(){
		return 	" Palavra: " + this.palavra + " " + this.chave;
	}
	
	
}
