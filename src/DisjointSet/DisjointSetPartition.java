package DisjointSet;

import java.util.ArrayList;

/**
 * Created by bernardog on 31/05/14.
 */
public class DisjointSetPartition {

    private ArrayList<DisjointSet> partition;

    public DisjointSetPartition() {
        this.partition = new ArrayList<DisjointSet>();
    }

    public ArrayList<DisjointSet> getPartition() {
        return partition;
    }

    public void setPartition(ArrayList<DisjointSet> partition) {
        this.partition = partition;
    }

}
