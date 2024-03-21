/* 
* KnowledgeEntry class.
*/

private static class KnowledgeEntry  {
    String term;
    String sentence;
    double confidenceScore;

    public KnowledgeEntry (String term, String sentence, double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }

    public String getTerm() {
        return term;
    }

    public String getSentence() {
        return sentence;
    }

    public float getConfidenceScore() {
        return confidenceScore;
    }
}
