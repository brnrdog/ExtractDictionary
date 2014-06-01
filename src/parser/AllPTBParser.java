package parser;

import DisjointSet.DisjointSet;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by bernardog on 28/05/14.
 */
public class AllPTBParser implements PTBParser{

    private FileReader file;

    public AllPTBParser(String file) throws FileNotFoundException {
        this.file = new FileReader(file);
    }

    public void parse(TreeMap tree) throws IOException {
        BufferedReader br = new BufferedReader(file);
        String line = null;
        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");
            for (String s : elements) {
                if (isWord(s)) {
                    while(s.charAt(s.length()-1) == ')') {
                        s = s.substring(0, s.length()-1);
                    }
                    DisjointSet ds = new DisjointSet(s);
                    tree.put(s, ds);
                }
            }
        }
    }

    public boolean isWord(String s) {
        return s.contains(")") && (s.charAt(0) != '.');
    }

}
