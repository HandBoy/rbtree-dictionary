import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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
			tools.rbInsert(rbtree, node);
		}
		
		System.out.println("\n IMPRIMINDO EM ORDEM");
		tools.inorderTreeWalk(rbtree.getRaiz());

		System.out.println("\n IMPRIMINDO O CHECK");
		tools.rbCheck(rbtree.getRaiz());
		//System.out.println(rbtree.getRaiz().details());
		/*Node novo = new Node("Esperanca");
		Node pesquisa = tools.rbSearch(rbtree.getRaiz(), novo);
		
		if(pesquisa == null){
			System.out.println("Palabra nao encontrada");
		} else {
			System.out.println(pesquisa.toString());
		}*/
	}

}
