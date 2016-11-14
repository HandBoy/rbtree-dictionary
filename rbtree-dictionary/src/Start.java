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
		
		if(args.length == 0){
			System.out.println("Passe algum arqumento para o programa");
			System.exit(0);
		}
		File arquivo = new File(args[0]);
		List<Node> palavras = null;
		if(arquivo.exists()){
			System.out.println("Arquivo Encontrado.");
			System.out.println(arquivo.getAbsolutePath());
			System.out.println("Palavra com mais de 20 caracteres não serão adicionadas.");
			palavras = Reader.lerArquivo(arquivo);
		} else {
			System.out.println("Arquivo Não Encontrado: " + args[0]);
			System.exit(0);
		}
		
		RBTreeDictionary rbtree = new RBTreeDictionary();
		RBTreeTools tools = new RBTreeTools();
				
		if(palavras == null){
			System.out.println("Arquivo vazio");
			System.exit(0);
		}
		
		for (Node node : palavras) {
			if(node.getAcao() == 1){
				tools.rbInsert(rbtree, node);
			}
			else {
				Node auxNode = tools.rbSearch(rbtree.getRaiz(), node);
				if(!(auxNode instanceof Nill)){
					System.out.println("Deletando a palavra: " + node.getPalavra());
					tools.rbDelete(rbtree, auxNode);
				} else {
					System.out.print("Não foi possível deletar a palavra: " + node.toString());
					System.out.println(", palavra nao encontrada.");
				}
				
			}
		}	
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
				if(palavra.length() < 21){
					node = new Node(palavra);
					tools.rbInsert(rbtree, node);
				} else {
					System.out.println("Palavra deve conter menos de 20 caracteres.");
				}
				
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
				System.out.println("Até a próxima!!!");
				break;
			}
			
		}
	}

}
