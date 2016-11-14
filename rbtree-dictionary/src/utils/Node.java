package utils;

public class Node implements Comparable{
	protected Node pai;
	protected Node esquerda;
	protected Node direita;
	protected String cor;
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
	}
	
	public Node() {
		super();		
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
	public boolean isBlack(){
		if(this.cor.equals("black"))
			return true;
		else
			return false;
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
	
	public int alturaNegra(){
		int qtd = 0;
		Node node = this.getEsquerda();
		while(!(node instanceof Nill) ){
			if(node.isBlack())
				qtd++;
			node = node.getEsquerda();
			
		}
		return qtd;
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
		stBuilder.append(", " + this.cor );
		stBuilder.append(", " + this.alturaNegra() );
		
		if(this.getEsquerda() instanceof Nill ){
			stBuilder.append(", NILL"); 
		} else {
			stBuilder.append(", " + this.getEsquerda().getPalavra()); 
		}
		
		if(this.getDireita() instanceof Nill ){
			stBuilder.append(", NILL "); 
		} else {
			stBuilder.append(", " + this.getDireita().getPalavra()); 
		}
		stBuilder.append(")");
		
		return stBuilder.toString();
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(this.palavra.compareToIgnoreCase((String) o) > 0)
			return 1;
		else if(this.palavra.compareToIgnoreCase((String) o) < 0)
			return -1;
		else
			return 0;
	}
	
	public String toString(){
		return this.palavra;
	}
	
}
