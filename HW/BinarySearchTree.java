import jdk.nashorn.internal.ir.ReturnNode;

public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
	E value;
	Node leftChild = null;
	Node rightChild = null;

	Node(E value) {
	    this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
	    if ((obj instanceof BinarySearchTree.Node) == false)
		return false;
	    @SuppressWarnings("unchecked")
	    Node other = (BinarySearchTree<E>.Node) obj;
	    return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
	}
    }

    protected Node root = null;

    protected void visit(Node n) {
	System.out.println(n.value);
    }

    public boolean contains(E val) {
	return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
	if (n == null)
	    return false;

	if (n.value.equals(val)) {
	    return true;
	} else if (n.value.compareTo(val) > 0) {
	    return contains(n.leftChild, val);
	} else {
	    return contains(n.rightChild, val);
	}
    }

    public boolean add(E val) {
	if (root == null) {
	    root = new Node(val);
	    return true;
	}
	return add(root, val);
    }

    protected boolean add(Node n, E val) {
	if (n == null) {
	    return false;
	}
	int cmp = val.compareTo(n.value);
	if (cmp == 0) {
	    return false; // this ensures that the same value does not appear more than once
	} else if (cmp < 0) {
	    if (n.leftChild == null) {
		n.leftChild = new Node(val);
		return true;
	    } else {
		return add(n.leftChild, val);
	    }
	} else {
	    if (n.rightChild == null) {
		n.rightChild = new Node(val);
		return true;
	    } else {
		return add(n.rightChild, val);
	    }
	}
    }

    public boolean remove(E val) {
	return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
	if (n == null)
	    return false;

	if (val.compareTo(n.value) == -1) {
	    return remove(n.leftChild, n, val);
	} else if (val.compareTo(n.value) == 1) {
	    return remove(n.rightChild, n, val);
	} else {
	    if (n.leftChild != null && n.rightChild != null) {
		n.value = maxValue(n.leftChild);
		remove(n.leftChild, n, n.value);
	    } else if (parent == null) {
		root = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else if (parent.leftChild == n) {
		parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else {
		parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    }
	    return true;
	}
    }

    protected E maxValue(Node n) {
	if (n.rightChild == null) {
	    return n.value;
	} else {
	    return maxValue(n.rightChild);
	}
    }

    /*********************************************
     * 
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/

    // Method #1.
    /*
     * Given a value that is stored in the BST, it returns the corresponding Node
     * that holds it. If the value does not exist in this BST, this method should
     * return null.
     */
    
    public Node findNode(E val) {

	if(val == null) return null;
	else return findNode(root, val); // I am overloading the method for facilitate the iterative research

    }
    
     protected Node findNode(Node n, E val) {

	 if(n == null) return null;
	 else {
	     if(n.value.equals(val)) return n;
	     else if(n.value.compareTo(val)>0) return findNode(n.leftChild, val);
	     else return findNode(n.rightChild, val);
	 }
	 
     }
     

    // Method #2.
     /*
      * Given a value, this method should return the �depth� of its Node,
      * which is the number of ancestors between that node and the root,
      * including the root but not the node itself. The depth of the root is defined to be 0;
      * the depth of its two children (if any) is defined to be 1;
      * the depth of the root�s grandchildren (if any) is defined to be 2; and so on.
      * If the value is null or does not exist in this BST, this method should return -1.
      */
    protected int depth(E val) {

	if(val == null) return -1;

	Node n = root;
	int depth = 0;
	
	
	while(true) {
	    if(n.value.equals(val)) {
		return depth;
	    }
	    else if(n.value.compareTo(val)>0) {
		n = n.leftChild;
		depth ++;
	    }
	    else {
		n = n.rightChild;
		depth ++;
	    }
	    if(n == null) return -1;
	    
	    
	}
	
    }

    // Method #3.
    /*
     * Given a value, this method should return the �height� of its Node,
     * which is the greatest number of nodes between that node and any descendant node that is a leaf,
     * including the leaf but not the node itself.
     * The height of a leaf node (i.e., one which has no children) is defined to be 0.
     * If the input value is null or does not exist in this BST, this method should return -1.
     */
    /*
    protected int height(E val) {

	if(val == null) return -1;

	Node n = findNode(val);
	if(n == null) return -1;
	
	if(n.leftChild==null && n.rightChild==null) return 0;//height of a leaf node
	//else {
	    int maxHeight = Math.max(height(n.leftChild.value), height(n.rightChild.value));
	    return maxHeight + 1; // do not forget the actual node
	//}
    }*/
    protected int height(E val) {
	if (val == null) return -1;
	    

	Node n = findNode(val);

	return height(n);

    }

    protected int height(Node n) {
	if (n == null) return -1;
	     
	if (n.leftChild == null && n.rightChild == null) return 0; // leaf node
	int maxHeight = Math.max(height(n.leftChild), height(n.rightChild));   
	return maxHeight+1;
    }


    // Method #4.
    /*
     * Given a Node, return true if the absolute value of the difference in heights
     * of its left and right children is 0 or 1, and return false otherwise. 
     * If the Node is null or does not exist in this BST, this method should return false.
     */
    protected boolean isBalanced(Node n) {

	if (n == null || !contains(n.value))
	    return false;

	int deltaHeight = Math.abs(height(n.leftChild) - height(n.rightChild));
	return deltaHeight < 1 ? true : false;

    }

    // Method #5. .
    public boolean isBalanced() {

	/* IMPLEMENT THIS METHOD! */

	return false; // this line is here only so this code will compile if you don't modify it

    }

}
