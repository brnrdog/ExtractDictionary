import parser.AdjectivePTBParser;
import parser.AllPTBParser;
import parser.PTBParser;
import parser.VerbPTBParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        WordsTree tree = new WordsTree();

        PTBParser parser = new AdjectivePTBParser("ptb-flat.txt");

        parser.parse(tree);

        /*for (Map.Entry<String, String> entry : tree.entrySet()) {
            System.out.println(entry.getKey());
        }*/

        /*tree.put("pray","pray");
        tree.put("rise","rise");
        tree.put("rime","rime");
        tree.put("ring","ring");
        tree.put("play","play");
        tree.put("raise","raise");
        tree.put("rint","rint");
        tree.put("trim","trim");
        */
        tree.groupWords();
        tree.printGroups();
    }
}
