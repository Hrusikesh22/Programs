package ds.tree.bt;

import ds.tree.BTNode;
import ds.tree.BTPrinter;
import ds.tree.utils.TreeUtils;

/**
 * Depth~Height of tree [O(n)]
 * @since 18/08/20
 */
public class HeightOfTree {
	public static void main(String[] s) {
		BTNode root = new BTNode(1);
		root.setLeft(new BTNode(2));
		root.setRight(new BTNode(3));
		root.getLeft().setLeft(new BTNode(4));
		root.getLeft().setRight(new BTNode(5));
		root.getLeft().getRight().setLeft(new BTNode(6));
		
		TreeUtils.print("I/P : Binary Tree");
		BTPrinter.printTree(root);
		
		TreeUtils.print("Height : " + height(root));
	}
	
	public static int height(BTNode root ) {
		if(root == null) return 0;
		
		int leftH = height(root.getLeft());
		int rightH = height(root.getRight());
		
		return Math.max(leftH, rightH) + 1;
	}
}



/*
      1               
     / \       
    /   \     
   2     3       
  / \           
 /   \          
 4   5           
    /           
    6           

 */
