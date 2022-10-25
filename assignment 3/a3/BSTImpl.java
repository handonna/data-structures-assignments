
package a3;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() { root=null; size=0; }

    public BSTImpl(int val) { this.root=new NodeImpl(val); size=1; }

    // The implementations given to you are intended to help you 
    // see how the linked cells work, and how to program with them.
    //
    // These methods are patterns to illustrate for you how to set up
    // the method implementations as recursion.
    //
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive helper methods.

    @Override
    // interface method ==================================================
    public int height() {       
      // It is not recursive itself, but it calls a recursive
      // private "helper" method and passes it access to the tree cells.
      return height_recursive(this.root);
    }
    // private recursive helper
    private int height_recursive(Node c) {
      // private inner "helper" method with different signature
      // this helper method uses recursion to traverse
      // and process the recursive structure of the tree of cells
      if (c==null) return -1;
      int lht = height_recursive(c.getLeft());
      int rht = height_recursive(c.getRight());
      return Math.max(lht,rht) + 1;
    }
    
    @Override
    // interface method ==================================================
    public boolean contains(int val) { 
      if(this.root==null) return false; 
      return contains_r(val,root); 
    }
    // private recursive helper
    private boolean contains_r(int val, Node c) {
      if(c == null) return false;
      if(c.getValue()==val) return true;
      return contains_r(val, c.getLeft()) || contains_r(val, c.getRight());
    }

    @Override
    // interface method, used by autograder, do not change
    public Node getRoot() { return this.root; }
    
    @Override
    // interface method ==================================================
    public int size() { return this.size; }

    
    @Override
    // interface method ===================================================
    public void remove(int value) { remove_r(value,this.root); }
    // private recursive helper
    private Node remove_r(int k, Node c) {
      if (c==null) return null; // item not found, nothing to do
      // now we know we have a real node to examine
      //int cflag = k.compareTo(c.getValue());
      int vc=c.getValue();
      if (k<vc) { // k is smaller than node
        c.setLeft(remove_r(k,c.getLeft()));
        return c;
      }
      else if (k>vc) { // k is larger than node
        c.setRight(remove_r(k,c.getRight()));
        return c;
      }
      else { // k==vc   // found it... now figure out how to rearrange
        // cases
        if (c.getLeft()==null && c.getRight()==null) { c = null; this.size--; } // leaf
        else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); this.size--; } // RC only
        else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); this.size--; } // LC only
        else { // 2 children
          Node mc = findMaxCell(c.getLeft());
          c.setValue(mc.getValue());
          c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
        }
        return c;
      }
    }
    // private recursive helper
    private Node findMaxCell(Node c) { 
      if (c.getRight()==null) return c;
      return findMaxCell(c.getRight());
    } 

  
   //====================================================================================
   //
   // The methods below here are part of the public BST interface we defined, 
   // but you will write the implementation code.
   // 
   // At the moment, they have return statements that return dummy values; this
   // is so they will compile, but those return values are just dummy behavior
   // you will replace the dummy returns with your own code and proper return values.
   //
   //====================================================================================

  
    @Override
    // interface method ==================================================
    public int insert(int val) {
        /*See BST.java for method specification */
        /*Your code here */
        /* Hint: Don't forget to update size */
        /* Hint: You can find examples of how to create a new Node object elsewhere in the code */
        root = insert_r(root, val);
        return val;
    }

    public Node insert_r(Node root, int val) {

        if (root == null) {
            root = new NodeImpl(val);
            size++;
            return root;
        }

        if (val < root.getValue()) {
            if (root.getLeft() == null) {
                Node a = new NodeImpl(val);
                root.setLeft(a);
                size++;
                return root;
            } else {
                insert_r(root.getLeft(), val);
            }
        }
        if (val > root.getValue()) {
            if (root.getRight() == null) {
                Node b = new NodeImpl(val);
                root.setRight(b);
                size++;
                return root;
            } else {
                insert_r(root.getRight(), val);
            }
            return root;
        }
        return root;


      //return 0; // Dummy return statement.  Remove when you implement!
    }

    @Override
    // interface method ==================================================
    public int findMin() {
        /*See BST.java for method specification */
        /* Your code here */
        int min;
        min = findMin_r(root);
        return min;
    }

    public int findMin_r(Node root) {
        if (root.getLeft() == null) {
            return root.getValue();
        } else {
            root = root.getLeft();
            return findMin_r(root);
        }


       // return Integer.MAX_VALUE; // Dummy return statement.  Remove when you implement!
    }
    
    @Override
    // interface method ==================================================
    public int findMax() {
        /*See BST.java for method specification */
        /* Your code here */
        int max;
        max = findMax_r(root);
        return max;
    }

    public int findMax_r(Node root) {
        if (root.getRight() == null) {
            return root.getValue();
        } else {
            root = root.getRight();
            return findMax_r(root);
        }


       //return Integer.MIN_VALUE; // Dummy return statement.  Remove when you implement!

    }
    
    @Override
    // interface method ==================================================
    public Node get(int val) {
        return get_r(root, val);

    }

    public Node get_r(Node root, int val) {
        if (val == root.getValue()) {
            return root;
        }
        if (val > root.getValue()) {
            return get_r(root.getRight(), val);
        }
        if (val < root.getValue()) {
            return get_r(root.getLeft(), val);
        }
        return root;


      //return null; // Dummy return statement.  Remove when you implement!
    }
    
    @Override
    // interface method ==================================================
    public boolean isFullBT() {
        /*See BST.java for method specification */
        /* Hint: How can you "break-up" the problem into smaller pieces? */
        /* Your code here */
        return isFull_r(root);
    }

    public boolean isFull_r(Node root) {
        if (root == null) {
            return true;
        }
        if(root.getLeft() == null && root.getRight() == null)
            return true;
        if ((root.getLeft() != null) && (root.getRight() != null)){
            return (isFull_r(root.getLeft()) && isFull_r(root.getRight()));
        }
        else{
            return false;
        }
        //return false; // Dummy return statement.  Remove when you implement!
    }
    
    @Override
    // interface method ==================================================
    public int merge(BST nbt) {
        /*See BST.java for method specification */
      // Hint: traverse bst using pre-order
      // as each node is visited, take the value there
      // and do this.insert(value)
      // have to somehow count when an add is successful
      // so we can return the number of nodes added
         /* Your code here */
        int original = this.size;
        int new_tree = merge_r(nbt.getRoot());
        return (new_tree - original);

    }
    private int merge_r(Node c) {
        if (c == null) {
            return 0;
        }
        this.insert(c.getValue());
        merge_r(c.getLeft());
        merge_r(c.getRight());
        return this.size;



        
        //return 0;  // Dummy return statement.  Remove when you implement!
    }

    public int getMaxLeafHeightDiff () {
        /*See BST.java for method specification */
        /* Hint: Which of the methods you're given are most similar to this? */
        /* Your code here */
        return heights_of_leaves(this.root);
    }
    private int heights_of_leaves(Node c) {
        // private inner "helper" method with different signature
        // this helper method uses recursion to traverse
        // and process the recursive structure of the tree of cells
        if (c == null) return -1;
        int lht = heights_of_leaves(c.getLeft());
        int rht = heights_of_leaves(c.getRight());
        return Math.abs(lht - rht);
    }


        
        //return 0;// Dummy return statement.  Remove when you implement!


}
