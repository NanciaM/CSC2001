// Nancia mwaramba
// 22 March 2024
// Hussein's Binary Tree

public class AVLTreeNode<dataType>
{
   String key;
   String sentence;
   String confidenceScore;
   AVLTreeNode<dataType> left;
   AVLTreeNode<dataType> right;
   int height;
   
   public AVLTreeNode ( String term, String statement, String conScore, AVLTreeNode<dataType> l, AVLTreeNode<dataType> r )
   {
      key= term;
      sentence = statement;
      confidenceScore= conScore;
      left = l;
      right = r;
      height = 0;
   }


   public  String getKey(){ return key; }
   public String getConfidenceScore(){ return confidenceScore; }
   public String getSentence(){ return sentence; }
   
   AVLTreeNode<dataType> getLeft () { return left; }
   AVLTreeNode<dataType> getRight () { return right; }
}

