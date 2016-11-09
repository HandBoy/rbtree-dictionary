import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
			if(node.getAcao() == 1){
				System.out.println("\n Adicionando palavra: " + node.getPalavra());
				tools.rbInsert(rbtree, node);
				//System.out.println("\n Checando a árvore: ");
				//tools.rbCheck(rbtree.getRaiz());
			}
			else {
				Node auxNode = tools.rbSearch(rbtree.getRaiz(), node);
				if(!(auxNode instanceof Nill)){
					System.out.println("\n Deletando a palavra: " + node.getPalavra());
					tools.rbDelete(rbtree, auxNode);
					//System.out.println("\n Checando a árvore: ");
					//tools.rbCheck(rbtree.getRaiz());
				} else {
					System.out.println("Não foi possível deletar a palavra: " + node.toString());
					System.out.println("Palavra nao encontrada.");
				}
				
			}
		}
		
		//Node node = tools.treeMinimum(rbtree.getRaiz());
		//System.out.println("\n IMPRIMINDO MINIMO: " + node.toString());
		//System.out.println("\n IMPRIMINDO EM ORDEM");
		//tools.inorderTreeWalk(rbtree.getRaiz());

		//System.out.println("\n IMPRIMINDO O CHECK");
		//tools.rbCheck(rbtree.getRaiz());		
		menu(rbtree, tools);			
	}
	
	private static void menu(RBTreeDictionary rbtree, RBTreeTools tools){
		String op="";
		Scanner scanner = new Scanner( System.in );
		String palavra = "";
		Node node = null;
		
		while(!op.equalsIgnoreCase("6")){
			System.out.println("\n===========================================");
			System.out.println("Escolha uma Opção");
			System.out.println("1 - Adicionar Palavra");
			System.out.println("2 - Buscar Palavra");
			System.out.println("3 - Deletar Palavra");
			System.out.println("4 - Mostrar Dicionário Palavra");
			System.out.println("5 - Checar Dicionário");
			System.out.println("6 - Sair");
			System.out.print("\n Escolha uma Opção: ");
			op = scanner.nextLine(); // para inteiros
			
			switch (op) {
			case "1":
				System.out.print("\n Digite a palavra a ser inserida: ");
				palavra = scanner.nextLine();
				node = new Node(palavra);
				tools.rbInsert(rbtree, node);
				break;
			case "2":
				System.out.print("\n Digite a palavra a ser buscada: ");
				palavra = scanner.nextLine();
				node = tools.rbSearch(rbtree.getRaiz(), new Node(palavra));
				if(!(node instanceof Nill)){
					System.out.println(node.details());
				} else {
					System.out.println("Palavra não encontrada.");
				}
				break;
				
			case "3":
				System.out.print("\n Digite a palavra a ser deletada: ");
				palavra = scanner.nextLine();
				node = tools.rbSearch(rbtree.getRaiz(), new Node(palavra));
				if(!(node instanceof Nill)){
					System.out.print("\n Palavra encontrada, iniciando a deleção ");
					tools.rbDelete(rbtree, node);
					tools.rbCheck(rbtree.getRaiz());
				} else {
					System.out.println("Palavra nao encontrada.");
				}
				break;
				
			case "4":
				System.out.println("\n IMPRIMINDO EM ORDEM");
				tools.inorderTreeWalk(rbtree.getRaiz());
				break;
				
			case "5":
				System.out.println("\n IMPRIMINDO O CHECK");
				tools.rbCheck(rbtree.getRaiz());
				break;

			default:
				break;
			}
			
		}
	}

}
