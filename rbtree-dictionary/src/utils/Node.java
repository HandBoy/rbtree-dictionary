package utils;

public class Node {
	protected Node pai;
	protected Node esquerda;
	protected Node direita;
	protected String cor;
	protected int chave;
	protected String palavra;
	protected int acao;	
	protected String primaryCor;

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
	
	public String getPrimalCor() {
		return primaryCor;
	}

	public void setPrimalCor(String zcor) {
		this.primaryCor = zcor;
	}

	public String details(){
		StringBuilder stBuilder = new StringBuilder();
		stBuilder.append("(");
		if(this.getPai() instanceof Nill ){
			stBuilder.append("NILL"); 
		} else {
			stBuilder.append(this.getPai().getPalavra()); 
		}	

		stBuilder.append(", " + this.palavra );
		stBuilder.append(", " + this.chave );		
		stBuilder.append(", " + this.cor );
		
		if(this.getEsquerda() instanceof Nill ){
			stBuilder.append(", NULL"); 
		} else {
			stBuilder.append(", " + this.getEsquerda().getPalavra()+ " " + this.getEsquerda().getChave()); 
		}
		
		if(this.getDireita() instanceof Nill ){
			stBuilder.append(", NULL "); 
		} else {
			stBuilder.append(", " + this.getDireita().getPalavra()+ " "  + this.getDireita().getChave()); 
		}
		stBuilder.append(")");
		
		return stBuilder.toString();
		
	}
	
	public String toString(){
		return 	" Palavra: " + this.palavra + " " + this.chave;
	}
	
	
}
