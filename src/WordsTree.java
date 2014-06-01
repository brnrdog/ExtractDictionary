import java.lang.reflect.Array;
import java.util.*;

import DisjointSet.DisjointSet;
import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;
import similarity.WordSimilarity;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordsTree extends TreeMap<String, DisjointSet> {

    public void wordMakeSets(){
        System.out.println(">> AGRUPANDO PALAVRAS POR SEMELHANÇA... AGUARDE.");
        TreeMap<Integer, ArrayList<String>> tree = new TreeMap<Integer, ArrayList<String>>();
        for (Map.Entry<String, DisjointSet> entry : this.entrySet()) {
            if (tree.get(entry.getKey().length()) == null) {
                tree.put(entry.getKey().length(), new ArrayList<String>());
            }
            tree.get(entry.getKey().length()).add(entry.getKey());
        }
        for (Map.Entry<Integer, ArrayList<String>> entry : tree.entrySet()) {
            ArrayList<String> possibleSimilarities= new ArrayList<String>();
            if (tree.get(entry.getKey() -1) != null) {
                possibleSimilarities.addAll(tree.get(entry.getKey() - 1));
            }
            if (tree.get(entry.getKey() + 1 ) != null) {
                possibleSimilarities.addAll(tree.get(entry.getKey() + 1));
            }
            for (String s : entry.getValue()) {
                for (String possible : possibleSimilarities) {

                    if (WordSimilarity.isSimilar(s, possible)) {
                        if (!(this.get(possible).getReference() == this.get(s).getReference())) {
//                            this.get(possible).setReference(this.get(s));
                            this.get(possible).union(this.get(s));
//                            System.out.println(s + " " + possible);
                        }
                    }
                }
            }
        }
    }

    public void printSimilarities(){
        System.out.println(">> IMPRIMINDO PALAVRAS POR ORDEM DE SEMELHANÇA... AGUARDE.");
        TreeMap<String, ArrayList<String>> treeSupport = new TreeMap<String, ArrayList<String>>();
        for (Map.Entry<String, DisjointSet> entry : this.entrySet()) {
            if (treeSupport.get(entry.getValue().getReference().getWord()) == null) {
                treeSupport.put(entry.getValue().getReference().getWord(), new ArrayList<String>());
            }
            treeSupport.get(entry.getValue().getReference().getWord()).add(entry.getKey());
        }
        for (Map.Entry<String, ArrayList<String>> entry : treeSupport.entrySet()) {
            System.out.println("*****************");
            for (String s : entry.getValue()) {
                System.out.println(s);
            }
        }
    }

}
