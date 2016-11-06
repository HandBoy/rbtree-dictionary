package arvore;

import utils.Node;

public class RBTreeTools {
	public void rbInsert(RBTreeDictionary rbtree, Node zNode){
		Node yNodeAux = null;
		Node xNodeAux =  rbtree.getRaiz();
		
		while(xNodeAux != null){
			yNodeAux = xNodeAux;
			if( zNode.getChave() < xNodeAux.getChave())
				xNodeAux = xNodeAux.getEsquerda();
			else
				xNodeAux = xNodeAux.getDireita();			
		}		
		zNode.setPai(yNodeAux);
		if (yNodeAux == null)
			rbtree.setRaiz(zNode);		
		else if (zNode.getChave() < yNodeAux.getChave()){
			System.out.println(zNode.toString() + " adicionada com sucesso");
			yNodeAux.setEsquerda(zNode);
		}
		else if (zNode.getChave() > yNodeAux.getChave()){
			System.out.println(zNode.toString() + " adicionada com sucesso");
			yNodeAux.setDireita(zNode);
		} else
				System.out.println(zNode.toString() + " Já existe no dicionário");
		
		zNode.setEsquerda(null);
		zNode.setDireita(null);
		zNode.setCor("red");
			
		insertFixUp(rbtree, zNode);
		
	}
	
	public void insertFixUp(RBTreeDictionary rbtree, Node zNode){
		while(zNode != null && zNode.getPai().getCor().equals("red")){
			if(zNode.getPai().getChave() == zNode.getPai().getPai().getChave()){
				Node yNodeAux = zNode.getPai().getPai();
				if(yNodeAux.getCor().equals("red")){
					zNode.getPai().setCor("black");
					yNodeAux.setCor("black");
					zNode.getPai().getPai().setCor("red");
					zNode = zNode.getPai().getPai();
				} else if (zNode.getChave() == zNode.getPai().getDireita().getChave()){
					zNode = zNode.getPai();
					leftRotate(rbtree, zNode);
					zNode.getPai().setCor("black");
					zNode.getPai().getPai().setCor("red");
					rightRotate(rbtree, zNode.getPai().getPai());					
				}
			} else {
				Node yNodeAux = zNode.getPai().getPai();
				if(yNodeAux.getCor().equals("red")){
					zNode.getPai().setCor("black");
					yNodeAux.setCor("black");
					zNode.getPai().getPai().setCor("red");
					zNode = zNode.getPai().getPai();
				} else if (zNode.getChave() == zNode.getPai().getEsquerda().getChave()){
					zNode = zNode.getPai();
					rightRotate(rbtree, zNode);
					zNode.getPai().setCor("black");
					zNode.getPai().getPai().setCor("red");
					leftRotate(rbtree, zNode.getPai().getPai());					
				}
			}
		}
		rbtree.getRaiz().setCor("black");
	}
	
	public void leftRotate(RBTreeDictionary rbtree, Node xNode){
		Node yNodeAux = xNode.getDireita();
		xNode.setDireita(yNodeAux.getEsquerda());
		
		if(yNodeAux.getEsquerda() != null)
			yNodeAux.getEsquerda().setPai(xNode);
		yNodeAux.setPai(xNode.getPai());
		
		if(xNode.getPai() == null)
			rbtree.setRaiz(yNodeAux);
		else if (xNode.getChave() == xNode.getPai().getEsquerda().getChave())
			xNode.getPai().setEsquerda(yNodeAux);
		else 
			xNode.getPai().setDireita(yNodeAux);
		
		yNodeAux.setEsquerda(xNode);
		xNode.setPai(yNodeAux);
	}
	
	public void rightRotate(RBTreeDictionary rbtree, Node xNode){
		Node yNodeAux = xNode.getEsquerda();
		xNode.setEsquerda(yNodeAux.getDireita());
		
		if(yNodeAux.getDireita() != null)
			yNodeAux.getDireita().setPai(xNode);
		yNodeAux.setPai(xNode.getPai());
		
		if(xNode.getPai() == null)
			rbtree.setRaiz(yNodeAux);
		else if (xNode.getChave() == xNode.getPai().getDireita().getChave())
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
		if(rbNodeTree == null || rbNodeTree.getChave() == palavra.getChave())
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
		if (node != null){
			System.out.println(node.details());
			rbCheck(node.getEsquerda());			
			rbCheck(node.getDireita());
		} 
	}
	
	public void inorderTreeWalk(Node node){
		if (node != null){
			inorderTreeWalk(node.getEsquerda());
			System.out.println(node.toString());
			inorderTreeWalk(node.getDireita());
		}
	}
	public void preorderTreeWalk(Node node){
		if (node != null){
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
