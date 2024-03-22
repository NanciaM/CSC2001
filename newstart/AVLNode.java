// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class AVLTreeNode<dataType>
{
   String key;
    dataType data;
   AVLTreeNode<dataType> left;
   AVLTreeNode<dataType> right;
   int height;
   
   public AVLTreeNode ( String term, dataType d, AVLTreeNode<dataType> l, AVLTreeNode<dataType> r )
   {
      key= term;
      data = d;
      left = l;
      right = r;
      height = 0;
   }

   public AVLTreeNode ( String term, dataType d)
   {
      key= term;
      data = d;
      left = null;
      right = null;
       
   }
   public  String getKey(){ return key; }
   public dataType getData(){ return data; }
   
   AVLTreeNode<dataType> getLeft () { return left; }
   AVLTreeNode<dataType> getRight () { return right; }
}
