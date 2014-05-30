import java.util.*;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordsTree extends TreeMap<String, String> {

    private ArrayList<WordGroup> groups;

    public WordsTree() {
        this.groups = new ArrayList<WordGroup>();
    }

    public boolean isWordGroup(String word){
        for (WordGroup w : groups){
            for (String s : w.getWords()){
                if (s.equals(word)){
                    return true;
                }
            }
        }
        return false;
    }

    public void groupWords(){
        for (Map.Entry<String, String> entry : this.entrySet()) {

            if (groups.size() > 0) {
                if(!isWordGroup(entry.getValue())){
                    for (int i = 0; i < groups.size(); i++) {
                        if (groups.get(i).isSimilar(entry.getValue())) {
                            groups.get(i).getWords().add(entry.getValue());
                        }
                    }
                    if(!isWordGroup(entry.getValue())){
                        groups.add(new WordGroup(entry.getValue()));
                    }
                }
            } else {
                groups.add(new WordGroup(entry.getValue()));
            }
        }
    }

    public void printGroups(){
        for (WordGroup group : groups) {
            if(group.getWords().size() > 1){
                System.out.println("======GRUPO====");
                for (String s : group.getWords()) {
                    System.out.println(s);
                }
            }
        }
    }

}
