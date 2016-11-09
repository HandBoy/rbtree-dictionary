import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;

import arvore.RBTreeDictionary;
import arvore.RBTreeTools;
import utils.Hash;
import utils.Nill;
import utils.Node;
import utils.Reader;

public class Start {

	public static void main(String[] args) {
		List<Node> palavras = Reader.lerArquivo(args[0]);
		RBTreeDictionary rbtree = new RBTreeDictionary();
		RBTreeTools tools = new RBTreeTools();

		System.out.println("Procurando Arquivo");
		
		
		
		if(palavras == null)
			System.out.println("Arquivo Não Encontrado");
		else
			System.out.println("Arquivo  Encontrado");
		
		
		for (Node node : palavras) {
			//System.out.println(node.toString() + " " + node.getAcao());
			if(node.getAcao() == 1)
				tools.rbInsert(rbtree, node);
			else {
				Node auxNode = tools.rbSearch(rbtree.getRaiz(), node);
				if(!(auxNode instanceof Nill)){
					tools.rbDelete(rbtree, auxNode);
				} else {
					System.out.println("Não foi possível deletar a palavra: " + node.toString());
					System.out.println("Palavra nao encontrada.");
				}
				
			}
		}
		
		//Node node = tools.treeMinimum(rbtree.getRaiz());
		//System.out.println("\n IMPRIMINDO MINIMO: " + node.toString());
		System.out.println("\n IMPRIMINDO EM ORDEM");
		//tools.inorderTreeWalk(rbtree.getRaiz());

		System.out.println("\n IMPRIMINDO O CHECK");
		tools.rbCheck(rbtree.getRaiz());
		
		int op=0;
		while(op != 5){
			System.out.println("\n Escolha uma Opção");
		}
	}

}
