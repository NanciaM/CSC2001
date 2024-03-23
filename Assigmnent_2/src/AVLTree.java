// AVL Tree
// 22 March 2024
// Nancia Mwramba
// reference:  Hussein Suleman' AVL Tree

public class AVLTree<dataType extends Comparable<? super dataType>>{
    AVLTreeNode<dataType> root; // Root node of the AVL tree
   
   public AVLTree ()
   {
      root = null; // Constructor initializes root to null
   }
   
   // Method to get the height of the AVL tree
   public int getHeight ()
   {
      return getHeight (root);
   }   

   // Recursive method to get the height of a specific node in the AVL tree
   public int getHeight ( AVLTreeNode<dataType> node )
   {
      if (node == null)
         return -1; // Base case

      // Recursive call to get height of left and right subtrees, then return the maximum height
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   public int getSize ()
   {
      return getSize (root); // Call getSize method with root node
   }   

   // Recursive method to get the size of a specific node and its subtree
   public int getSize ( AVLTreeNode<dataType> node )
   {
      if (node == null)
         return 0; // Base case: if node is null, size is 0
	// Recursive call to get size of left and right subtrees, then add 1 for the current node
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
// Method to print
   public void visit ( AVLTreeNode<dataType> node )
   {
	   // Print the key, sentence, and confidence score of the node
       if (node != null) {
	    System.out.println (node.getKey()+ ": "+node.getSentence()+" (" +node.getConfidenceScore()+")");    
   } 
   // Print error message if the node is null
    else {
        System.out.println("Term not found: " + node.getKey());
    }
   }

   // Method to perform an in-order traversal of the AVL tree
   public void inOrder ()
   {
      inOrder (root);
   }

   // Recursive method to perform in-order traversal starting from a specific node
   public void inOrder ( AVLTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   // Method to get the root of the AVL tree
   public AVLTreeNode<dataType> getRoot() {
        return root;
    }

   // Method to get the height of a node
   public int height ( AVLTreeNode<dataType> node )
   {
      if (node != null)
         return node.height; // Return the height of the node
      return -1;// Return -1 if node is null

   }

   // Method to calculate the balance factor of a node
   public int balanceFactor ( AVLTreeNode<dataType> node )
   {
	// Return the difference in height between the right and left subtrees
      return height (node.right) - height (node.left);
   }
   
   // Method to update the height of a node based on its children
   public void fixHeight ( AVLTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
      // Update the height of the node as the maximum height of its children plus 1
   }
   
   // Method to perform a right rotation on a node
   public AVLTreeNode<dataType> rotateRight ( AVLTreeNode<dataType> p)
   {
	   // Perform the right rotation
      AVLTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      // Update the heights of the nodes after rotation
      fixHeight (p);
      fixHeight (q);
      return q;// Return the new root of the subtree after rotation
   }

   // Method to perform a left rotation on a node
   public AVLTreeNode<dataType> rotateLeft ( AVLTreeNode<dataType> q )
   {
	   // Perform the left rotation
      AVLTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      // Update the heights of the nodes after rotation
      fixHeight (q);
      fixHeight (p);
      return p;// Return the new root of the subtree after rotation

   }

// Method to balance a node in the AVL tree
   public AVLTreeNode<dataType> balance ( AVLTreeNode<dataType> p )
   {
      fixHeight (p);
      // Check if the node is unbalanced
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      // Perform left rotation on the left child if it's unbalanced
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;// Return the balanced node
   }

   // Method to insert a new node into the AVL tree
   public void insert ( String term, String statement, String conScore)
   {
      root = insert (term, statement, conScore, root);
   }

   // Recursive method to insert a new node into the AVL tree
   public AVLTreeNode<dataType> insert ( String term, String statement, String conScore, AVLTreeNode<dataType> node )
   {
      if (node == null) // If the current node is null, create a new node with the given data
         return new AVLTreeNode<dataType> (term, statement, conScore, null, null);
      if (term.compareTo (node.key) <= 0) // If the term is less than or equal to the key of the current node, recursively insert into the left subtree
         node.left = insert (term,  statement, conScore, node.left);
      else
         node.right = insert (term,  statement, conScore, node.right);
      return balance (node);// Balance the tree after insertion and return the balanced node
   }

   // Method to find a node in the AVL tree by term, statement, and confidence score
   public AVLTreeNode<dataType> find ( String term, String statement, String conScore )
   {
      if (root == null)
         return null;
      else
         return find (term, statement, conScore, root);
   }

// Recurcive Method  to find a node
   public AVLTreeNode<dataType> find ( String term, String statement, String conScore, AVLTreeNode<dataType> node )
   {
      if (term.compareTo (node.key) == 0) 
         return node;
      else if (term.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (term,  statement, conScore, node.left);
      else
         return (node.right == null) ? null : find (term,  statement, conScore, node.right);
   }
}
