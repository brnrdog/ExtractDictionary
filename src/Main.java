import parser.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        WordsTree tree = new WordsTree();

//        PTBParser parser = new AllPTBParser("ptp-flat-test.txt");
        PTBParser parser = new VerbPTBParser("ptb-flat.txt");

        parser.parse(tree);

//        for (Map.Entry<String, String> entry : tree.entrySet()) {
//            System.out.println(entry.getKey());
//        }

        /*tree.put("pray","pray");
        tree.put("rise","rise");
        tree.put("rime","rime");
        tree.put("ring","ring");
        tree.put("play","play");
        tree.put("raise","raise");
        tree.put("rint","rint");
        tree.put("trim","trim");
        */
        tree.wordMakeSets();
        tree.printSimilarities();
//        tree.printGroups();
    }
}
