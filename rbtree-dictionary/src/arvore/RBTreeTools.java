package arvore;

import utils.Nill;
import utils.Node;

public class RBTreeTools {
	public void rbInsert(RBTreeDictionary rbtree, Node zNode){
		Node yNodeAux = rbtree.getNill();
		Node xNodeAux =  rbtree.getRaiz();
		
		while(!(xNodeAux instanceof Nill)){
			yNodeAux = xNodeAux;
			if( zNode.getChave() < xNodeAux.getChave())
				xNodeAux = xNodeAux.getEsquerda();
			else
				xNodeAux = xNodeAux.getDireita();			
		}		
		zNode.setPai(yNodeAux);
		if (yNodeAux instanceof Nill){			
			rbtree.setRaiz(zNode);	
			System.out.println(zNode.toString() + " adicionada com sucesso");
		}
		else if (zNode.getChave() < yNodeAux.getChave()){			
			yNodeAux.setEsquerda(zNode);
			System.out.println(zNode.toString() + " adicionada com sucesso");
		}
		else if (zNode.getChave() > yNodeAux.getChave()){			
			yNodeAux.setDireita(zNode);
			System.out.println(zNode.toString() + " adicionada com sucesso");
		} else
				System.out.println(zNode.toString() + " Já existe no dicionário");
		
		zNode.setEsquerda(rbtree.getNill());
		zNode.setDireita(rbtree.getNill());
		zNode.setCor("red");
			
		insertFixUp(rbtree, zNode);
		
	}
	
	public void insertFixUp(RBTreeDictionary rbtree, Node zNode){
		while(zNode.getPai().getCor().equals("red")){
			if(zNode.getPai() == zNode.getPai().getPai().getEsquerda()){
				Node yNodeAux = zNode.getPai().getPai().getDireita();
				if(yNodeAux.getCor().equals("red")){
					zNode.getPai().setCor("black");
					yNodeAux.setCor("black");
					zNode.getPai().getPai().setCor("red");
					zNode = zNode.getPai().getPai();
				} else {
					if (zNode == zNode.getPai().getDireita()){
						zNode = zNode.getPai();
						leftRotate(rbtree, zNode);	
					}
					zNode.getPai().setCor("black");
					zNode.getPai().getPai().setCor("red");
					System.out.println("rightRotate"+ zNode.toString());
					rightRotate(rbtree, zNode.getPai().getPai());
				}				
				
			} else {
				Node yNodeAux = zNode.getPai().getPai().getEsquerda();
				if(yNodeAux.getCor().equals("red")){
					zNode.getPai().setCor("black");
					yNodeAux.setCor("black");
					zNode.getPai().getPai().setCor("red");
					zNode = zNode.getPai().getPai();
				} else {
					if (zNode == zNode.getPai().getEsquerda()){
						zNode = zNode.getPai();
						rightRotate(rbtree, zNode);		
					}
					zNode.getPai().setCor("black");
					zNode.getPai().getPai().setCor("red");
					System.out.println("leftRotate"+ zNode.toString());
					leftRotate(rbtree, zNode.getPai().getPai());													
				}				
			}
		}
		rbtree.getRaiz().setCor("black");
	}
	
	public void leftRotate(RBTreeDictionary rbtree, Node xNode){
		Node yNodeAux = xNode.getDireita();
		xNode.setDireita(yNodeAux.getEsquerda());
		
		if(!(yNodeAux.getEsquerda() instanceof Nill))
			yNodeAux.getEsquerda().setPai(xNode);
		yNodeAux.setPai(xNode.getPai());
		
		if((yNodeAux.getPai() instanceof Nill))
			rbtree.setRaiz(yNodeAux);
		else if (xNode == xNode.getPai().getEsquerda())
			xNode.getPai().setEsquerda(yNodeAux);
		else 
			xNode.getPai().setDireita(yNodeAux);
		
		yNodeAux.setEsquerda(xNode);
		xNode.setPai(yNodeAux);
	}
	
	public void rightRotate(RBTreeDictionary rbtree, Node xNode){
		Node yNodeAux = xNode.getEsquerda();
		xNode.setEsquerda(yNodeAux.getDireita());
		
		if(!(yNodeAux.getDireita() instanceof Nill))
			yNodeAux.getDireita().setPai(xNode);
		yNodeAux.setPai(xNode.getPai());
		
		if((yNodeAux.getPai() instanceof Nill))
			rbtree.setRaiz(yNodeAux);
		else if (xNode == xNode.getPai().getDireita())
			xNode.getPai().setDireita(yNodeAux);
		else 
			xNode.getPai().setEsquerda(yNodeAux);
		
		yNodeAux.setDireita(xNode);
		xNode.setPai(yNodeAux);
	}
	
	public boolean rbDelete(RBTreeDictionary rbtree, Node novo){
		return false;
	}
	
	public Node rbSearch(Node rbNodeTree, Node palavra){
		if(!(rbNodeTree instanceof Nill) || rbNodeTree.getChave() == palavra.getChave())
			return rbNodeTree;
		if(palavra.getChave() < rbNodeTree.getChave())
			return rbSearch(rbNodeTree.getEsquerda(), palavra);
		else
			return rbSearch(rbNodeTree.getDireita(), palavra);
	}
	
	public boolean rbPrint(RBTreeDictionary rbtree){
		return false;
	}
	
	public void rbCheck(Node node){
		if (!(node instanceof Nill)){
			System.out.println(node.details());
			rbCheck(node.getEsquerda());			
			rbCheck(node.getDireita());
		} 
	}
	
	public void inorderTreeWalk(Node node){
		if (!(node instanceof Nill)){
			inorderTreeWalk(node.getEsquerda());
			System.out.println(node.toString());
			inorderTreeWalk(node.getDireita());
		}
	}
	public void preorderTreeWalk(Node node){
		if (!(node instanceof Nill)){
			System.out.println(node.toString());
			inorderTreeWalk(node.getEsquerda());			
			inorderTreeWalk(node.getDireita());
		} 
	}
	
	public String treeMinimum(Node node){
		while (node.getEsquerda() != null)
			node = node.getEsquerda();
		return node.toString();
	}
	
	public String treeMaximum(Node node){
		while (node.getDireita() != null)
			node = node.getDireita();
		return node.toString();
	}
	
	
}
