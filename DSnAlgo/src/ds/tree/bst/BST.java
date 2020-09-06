package ds.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.tree.BTNode;
import ds.tree.utils.TreeUtils;

/*
 * //L<D<R
 */
public class BST {

	/**
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static BTNode insert(BTNode root, int data) {
		
		if(root == null) {//Invalid tree
			root = new BTNode(data);
			return root;
		}
		
		if(root.getData() == data)//already present
			return root;
		
		if(root.getData()< data) {
			root.setRight(insert(root.getRight(), data));
		}
		
		if(data < root.getData() ) {
			root.setLeft(insert(root.getLeft(), data));
		}
		
		return root;
	}
	
	/**
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static BTNode delete(BTNode root, int data) {
		
		if(root == null)
			return null;
		
		if(root.getData() == data) {//Match Found
			
			if(TreeUtils.hasTwoChildren(root)) {
				BTNode IOPredecessor = getInOrderPredecessor(root.getLeft());
				root.setData(IOPredecessor.getData());							// Copy InOrderPredecessor node value to the matching node to be deleted.
				root.setLeft(delete(root.getLeft(), IOPredecessor.getData()));	//Now delete InOrderPredecessor node.
			} 
			else if(TreeUtils.hasOneChild(root)) {
				root = TreeUtils.getOneChild_LeftOrRight(root);
			} 
			else if(TreeUtils.isLeaf(root)) {
				root = null;
			}
		}
		else if(root.getData() < data) {
			root.setRight(delete(root.getRight(), data));
		} 
		else if(root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data));
		}
		
		return root;
		
		
			
		
	}
	
	/**
	 *
	 * Deque - Double Ended Queue
	 * PriorityQueue & LinkedList are not thread safe.
	 * PriorityBlockingQueue is an alternative being thread safe.
	 *
	 *				|--Queue <-- AbstractQueue <-- **PriorityQueue**
	 * 				|
	 * Collections-
	 * 				|			|-- **LinkedList**
	 * 				|--Deque--
	 * 							|-- ArrayDeque
	 *
	 * 
	 * 
	 * @param root
	 */
	
	public static void levelOrder_Traverse(BTNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		//NOTE: PQ doesn't allow to insert 'null', so LinkedList instead. Also PQ is a heap
		//Queue<TreeNode> q = new PriorityQueue<TreeNode>(); 
		
		Queue<BTNode> q = new LinkedList<BTNode>();
		
		if(root == null)//IMP: base case 
			return;
		
		q.offer(root);
		q.offer(null); //Null used as level separator
		
		while(!q.isEmpty()) {
			BTNode top = q.poll();
			if(top != null) {
				if(top.getLeft()!=null) 				// IMP : Or else will result infinite loop. 
					q.offer(top.getLeft());
				if(top.getRight() != null) 				// IMP : Or else will result infinite loop. 
					q.offer(top.getRight());
			} else {
				if(!q.isEmpty())
					q.offer(null);
			}
			
			result.add(top != null ? top.getData() : null);
		}
		
		for(Integer i : result)
			System.out.print(i+" ");
	}
	
	//Call this method as getInOrderPredecessor(Node.Left) to get InOrder Predecessor of a Node.
	public static BTNode getInOrderPredecessor(BTNode node) {
		
		if(node != null && node.getRight() == null) {
			return node;
		} else {
			return getInOrderPredecessor(node.getRight());
		}
	} 
	
	//Call directly getInOrderSuccessor(Node) to get InOrder Successor of a Node. 
	public static BTNode getInOrderSuccessor(BTNode node) {
		return getInOrderPredecessor(node);
	}
}


