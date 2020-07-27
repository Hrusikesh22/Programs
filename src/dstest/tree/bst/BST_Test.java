package dstest.tree.bst;

import ds.tree.BTNode;
import ds.tree.BTPrinter;
import ds.tree.bst.BST;
import ds.tree.utils.TreeUtils;

/**
 *             10                               
              / \               
       	     7   12               
              \  / \     
               9 11 15       
                      \  
                       20   
                         \ 
                          50
 * 
 * @author hb670444
 *
 */
public class BST_Test {
	public static void main(String[] s) {
		
		BTNode root = new BTNode(10);
		BST.insert(root, 12);
		BST.insert(root, 11);
		BST.insert(root, 7);
		BST.insert(root, 15);
		BST.insert(root, 9);
		BST.insert(root, 20);
		BST.insert(root, 50);

		TreeUtils.print("Tree Structure...");
		BTPrinter.printTree(root);

		//TreeUtils.print("Level Order Traversal...");
		//BST.levelOrder_Traverse(root);

		//NOTE: Pass Node.Left to get InOrder Predecessor of a Node. 
		/*TreeUtils.print("InOrder Predecessor of 10 ==> " + 
				BST.getInOrderPredecessor(root.getLeft()).getData());*/

		//NOTE: Pass Node directly to get InOrder Successor of a Node. 
		/*TreeUtils.print("InOrder Successor of 10 ==> " + 
				BST.getInOrderSuccessor(root).getData());*/
		
		//TreeUtils.print("Deleting 50...");
		//BST.delete(root, 50);//Delete Leaf
		//BST.delete(root, 20);//Delete Node with One Child
		//BST.delete(root, 10);//Delete Node with Two Child

		TreeUtils.print("Tree Structure After Deleting...");
		BTPrinter.printTree(root);
		
	}
}
