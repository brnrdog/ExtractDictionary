package DisjointSet;

import similarity.WordSimilarity;

/**
 * Created by bernardog on 31/05/14.
 */
public class DisjointSet {

    private DisjointSet reference;
    private String word;
    private int degree;

    public DisjointSet(String word) {
        this.reference = this;
        this.word = word;
    }

    public DisjointSet(DisjointSet reference, String word) {
        this.reference = reference;
        this.word = word;
    }

    public void union(DisjointSet other) {
        // Se this tiver o grau maior, a referência vai para o other.
        if (this.getDegree() > other.getDegree()) {
            this.getReference().setReference(other.getReference());
            other.getReference().setDegree(this.getDegree());
        }
        // Caso contrário, a referência vai para this.
        else {
            other.getReference().setReference(this.getReference());
            this.getReference().setDegree(other.getDegree());
        }
        if (this.getDegree() == other.getDegree()) {
            this.getReference().increaseDegree();
            other.getReference().increaseDegree();
        }

    }

    public boolean findSet(DisjointSet ds, String word) {
        if (ds.reference == ds) return false;
        if (ds.word == word) return true;
        findSet(ds.reference, word);
        return false;
    }

    public boolean isSimilar(DisjointSet other) {
        return WordSimilarity.isSimilar(this.word, other.getWord());
    }

    private void increaseDegree() {
        this.degree++;
    }

    public DisjointSet getReference() {
        DisjointSet lastRef = this;

        while (reference.getWord() != lastRef.getWord()) {
            lastRef = reference;
            setReference(reference.getReference());
        }

        return reference;
    }

    public void setReference(DisjointSet reference) {
        this.reference = reference;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDegree() {
        if (this.getReference() == this) {
            return this.degree;
        }
        else return this.reference.getDegree();
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
