/* 
* KnowledgeEntry class.
*/

public class KnowledgeEntry implements Comparable<KnowledgeEntry> {
    String term;
    String sentence;
    String confidenceScore;

    public KnowledgeEntry (String term, String sentence, String confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }

    public KnowledgeEntry (String sentence, String confidenceScore) {
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }
    public KnowledgeEntry (String term) {
        this.term = term;
    } 


    public String getTerm() {
        return term;
    }

    public String getSentence() {
        return sentence;
    }

    public String getConfidenceScore() {
        return confidenceScore;
    }
    public int compareTo(KnowledgeEntry other) {
        return this.term.compareTo(other.term);
    }
}