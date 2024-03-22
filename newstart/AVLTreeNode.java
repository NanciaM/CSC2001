// AVL Tree
// 22 March 2024
// Nancia Mwramba
// reference:  Hussein Suleman' AVL Tree

public class AVLTree<dataType extends Comparable<? super dataType>>{
    AVLTreeNode<dataType> root;
   
   public AVLTree ()
   {
      root = null;
   }
   
   public int getHeight ()
   {
      return getHeight (root);
   }   
   public int getHeight ( AVLTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( AVLTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   public void visit ( AVLTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( AVLTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   public int height ( AVLTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( AVLTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( AVLTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public AVLTreeNode<dataType> rotateRight ( AVLTreeNode<dataType> p )
   {
      AVLTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public AVLTreeNode<dataType> rotateLeft ( AVLTreeNode<dataType> q )
   {
      AVLTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public AVLTreeNode<dataType> balance ( AVLTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( String term )
   {
      root = insert (term, root);
   }
   public AVLTreeNode<dataType> insert ( String term, String statement, String conScore, AVLTreeNode<dataType> node )
   {
      if (node == null)
         return new AVLTreeNode<dataType> (term, null, null);
      if (term.compareTo (node.key) <= 0)
         node.left = insert (term, node.left);
      else
         node.right = insert (term, node.right);
      return balance (node);
   }

   public AVLTreeNode<dataType> find ( String term )
   {
      if (root == null)
         return null;
      else
         return find (term, root);
   }
   public AVLTreeNode<dataType> find ( String term, String statement, String conScore, AVLTreeNode<dataType> node )
   {
      if (term.compareTo (node.key) == 0) 
         return node;
      else if (term.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (term, node.left);
      else
         return (node.right == null) ? null : find (term, node.right);
   }
}
