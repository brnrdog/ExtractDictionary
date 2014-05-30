import java.util.ArrayList;
import java.util.Iterator;

import similarity.WordSimilarity;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordGroup {

    private ArrayList<String> words;

    public WordGroup(String s) {
        this.words = new ArrayList<String>();
        this.words.add(s);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public boolean isSimilar(String s){
        String word = this.words.get(0);
        if((s.length() - word.length()) < 1 || (s.length() - word.length()) > 1) {
            if (WordSimilarity.compute(word, s) == 1) {
                return true;	
            }
        }
        return false;
    }

}
