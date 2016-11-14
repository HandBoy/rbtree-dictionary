package arvore;

import utils.Nill;
import utils.Node;

public class RBTreeTools {
	public void rbInsert(RBTreeDictionary rbtree, Node zNode){
		Node yNodeAux = rbtree.getNill();
		Node xNodeAux =  rbtree.getRaiz();
		
		//Buscando o nó que irá ser pai do zNode
		while(!(xNodeAux instanceof Nill)){
			yNodeAux = xNodeAux;
			if( zNode.compareTo(xNodeAux.getPalavra()) < 0)
				xNodeAux = xNodeAux.getEsquerda();
			else
				xNodeAux = xNodeAux.getDireita();			
		}		
		zNode.setPai(yNodeAux);
		if (yNodeAux instanceof Nill){			
			rbtree.setRaiz(zNode);	
			System.out.println(zNode.toString() + " adicionada com sucesso");
		}
		else if (zNode.compareTo(yNodeAux.getPalavra()) < 0){			
			yNodeAux.setEsquerda(zNode);
			System.out.println(zNode.getPalavra() + " < " + yNodeAux.getPalavra());
			System.out.println(zNode.toString() + " adicionada com sucesso");
		}
		else if (zNode.compareTo(yNodeAux.getPalavra()) > 0){			
			yNodeAux.setDireita(zNode);
			System.out.println(zNode.getPalavra() + " > " + yNodeAux.getPalavra());
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
					//System.out.println("rightRotate"+ zNode.toString());
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
					//System.out.println("leftRotate"+ zNode.toString());
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
	
	public void rbDelete(RBTreeDictionary rbtree, Node zNode){
		Node y = zNode;
		Node x = new Node();
		y.setPrimalCor(y.getCor());
		if (zNode.getEsquerda() == rbtree.getNill()) {
			x = zNode.getDireita();
			rbTransplant(rbtree, zNode, zNode.getDireita());
		} else if (zNode.getDireita() == rbtree.getNill()){
			x = zNode.getEsquerda();
			rbTransplant(rbtree, zNode, zNode.getEsquerda());
		} else {
			y = treeMinimum(rbtree, zNode.getDireita());
			y.setPrimalCor(y.getCor());
			x = y.getDireita();
			if(y.getPai() == zNode){
				x.setPai(y);
			} else {
				rbTransplant(rbtree, y, y.getDireita());
				y.setDireita(zNode.getDireita());
				y.getDireita().setPai(y);
			}
			rbTransplant(rbtree, zNode, y);
			y.setEsquerda(zNode.getEsquerda());
			y.getEsquerda().setPai(y);
			y.setCor(zNode.getCor());			
		}
		if(y.getPrimalCor().equals("black"))
			rbDeleteFixup(rbtree, x);
		System.out.println("Palavra: " + zNode.getPalavra() + " deletada com sucesso");
	}
	
	public void rbDeleteFixup(RBTreeDictionary rbtree, Node xNode){
		while(xNode != rbtree.getRaiz() && xNode.getCor().equals("black")){
			if(xNode == xNode.getPai().getEsquerda()){
				Node w = xNode.getPai().getDireita();
				if(w.getCor().equals("red")){
					w.setCor("black");								/// CASE 1
					xNode.getPai().setCor("red");					/// CASE 1
					leftRotate(rbtree, xNode.getPai());				/// CASE 1
					w = xNode.getPai().getDireita();				/// CASE 1
				}
				if(w.getEsquerda().getCor().equals("black") && w.getDireita().getCor().equals("black")){					
					w.setCor("red");								/// CASE 2
					xNode = xNode.getPai();							/// CASE 2
				} else {
					if(w.getDireita().getCor().equals("black")){						
						w.getEsquerda().setCor("black");			/// CASE 3
						w.setCor("red");							/// CASE 3
						rightRotate(rbtree, w);						/// CASE 3
						w = xNode.getPai().getDireita();			/// CASE 3
					}
					w.setCor(xNode.getPai().getCor());				/// CASE 3
					xNode.getPai().setCor("black");					/// CASE 3
					w.getDireita().setCor("black");					/// CASE 3
					leftRotate(rbtree, xNode.getPai());				/// CASE 3
					xNode = rbtree.getRaiz();						/// CASE 3
				}
			} else {
				Node w = xNode.getPai().getEsquerda();
				if(w.getCor().equals("red")){
					/// CASE 1
					w.setCor("black");
					xNode.getPai().setCor("red");
					rightRotate(rbtree, xNode.getPai());
					w = xNode.getPai().getEsquerda();
				}
				if(w.getDireita().getCor().equals("black") && w.getEsquerda().getCor().equals("black")){
					/// CASE 2
					w.setCor("red");
					xNode = xNode.getPai();
				} else {
					if(w.getEsquerda().getCor().equals("black")){
						/// CASE 3
						w.getDireita().setCor("black");
						w.setCor("red");
						leftRotate(rbtree, w);
						w = xNode.getPai().getEsquerda();
					}
					/// CASE 4
					w.setCor(xNode.getPai().getCor());
					xNode.getPai().setCor("black");
					w.getEsquerda().setCor("black");
					rightRotate(rbtree, xNode.getPai());
					xNode = rbtree.getRaiz();
				}
			}
		}
		xNode.setCor("black");
	}
	
	public Node rbSearch(Node rbNodeTree, Node palavra){
		if((rbNodeTree instanceof Nill) || rbNodeTree.compareTo(palavra.getPalavra()) == 0)
			return rbNodeTree;
		if(rbNodeTree.compareTo(palavra.getPalavra()) > 0)
			return rbSearch(rbNodeTree.getEsquerda(), palavra);
		else
			return rbSearch(rbNodeTree.getDireita(), palavra);
	}
	
	public boolean rbPrint(RBTreeDictionary rbtree){
		return false;
	}
	
	public void rbTransplant(RBTreeDictionary rbtree, Node uAux, Node vAux){
		if(uAux.getPai() == rbtree.getNill()){
			rbtree.setRaiz(vAux);
		} else if(uAux == uAux.getPai().getEsquerda()){
			uAux.getPai().setEsquerda(vAux);
		} else {
			uAux.getPai().setDireita(vAux);
		}
		vAux.setPai(uAux.getPai());			
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
	
	public Node treeMinimum(RBTreeDictionary rbtree, Node node){
		while (!(node.getEsquerda() == rbtree.getNill()))
			node = node.getEsquerda();
		return node;
	}
	
	public Node treeMaximum(RBTreeDictionary rbtree, Node node){
		while (!(node.getDireita() == rbtree.getNill()))
			node = node.getDireita();
		return node;
	}
	
	
}
