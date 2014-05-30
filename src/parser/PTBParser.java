package parser;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Created by bernardog on 29/05/14.
 */
public interface PTBParser {

    public void parse(TreeMap tree) throws IOException;

}
