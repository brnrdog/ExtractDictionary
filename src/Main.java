import parser.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        Scanner scan = new Scanner(System.in);
        String file = "ptb-flat.txt";
        WordsTree tree = new WordsTree();
        boolean on = true;

        while(on) {
            System.out.println("BEM-VINDO AO EXTRACTDICTIONARY. POR FAVOR, ESCOLHA UMA DAS OPCOES:");
            System.out.println("1 - AGRUPAR E IMPRIMIR TODAS AS PALAVRAS POR SEMELHANCA (TEMPO MEDIO DE 4 ~ 8 MINUTOS)");
            System.out.println("2 - AGRUPAR E IMPRIMIR TODOS OS VERBOS POR SEMELHANCA (TEMPO MEDIO 10 ~ 20 SEGUNDOS)");
            System.out.println("3 - AGRUPAR E IMPRIMIR TODOS OS SUBSTANTIVOS POR SEMELHANCA (TEMPO MEDIO 1 ~ 4 MINUTOS)");
            System.out.println("4 - AGRUPAR E IMPRIMIR TODOS OS ADJETIVOS POR SEMELHANCA (TEMPO MEDIO 10 ~ 20 SEGUNDOS)");
            System.out.println("5 - AGRUPAR E IMPRIMIR TODOS OS ADVERBIOS POR SEMELHANCA (TEMPO MEDIO 3 ~ 5 SEGUNDOS)");
            System.out.println("6 - SAIR DO PROGRAMA");

            String opt = scan.nextLine();

            switch (opt.charAt(0)) {
                case '1':
                    System.out.println("ESCOLHIDO [TODAS AS PALAVRAS]");
                    PTBParser parser = new AllPTBParser(file);
                    parser.parse(tree);
                    tree.wordMakeSets();
                    tree.printSimilarities();
                    break;
                case '2':
                    System.out.println("ESCOLHIDO [VERBOS]");
                    parser = new VerbPTBParser(file);
                    parser.parse(tree);
                    tree.wordMakeSets();
                    tree.printSimilarities();
                    break;
                case '3':
                    System.out.println("ESCOLHIDO [SUBSTANTIVOS]");
                    parser = new SubstantivePTBParser(file);
                    parser.parse(tree);
                    tree.wordMakeSets();
                    tree.printSimilarities();
                    break;
                case '4':
                    System.out.println("ESCOLHIDO [ADJETIVOS]");
                    parser = new AdjectivePTBParser(file);
                    parser.parse(tree);
                    tree.wordMakeSets();
                    tree.printSimilarities();
                    break;
                case '5':
                    System.out.println("ESCOLHIDO [ADVERBIOS]");
                    parser = new AdverbPTBParser(file);
                    parser.parse(tree);
                    tree.wordMakeSets();
                    tree.printSimilarities();
                    break;
                case '6':
                    on = false;
                    break;
                default:
                    System.out.println("ERRO: DIGITE UMA OPCAO VALIDA!");
                    break;
            }
        }
    }
}
