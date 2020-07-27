package ds.tree.utils;

import ds.tree.BTNode;

public class TreeUtils {
	
	public static void print(String msg) {
		System.out.println("-------------------------------------------------");
		System.out.println(msg);
		System.out.println("-------------------------------------------------");
	}
	
	public static boolean isLeaf(BTNode node) {
		return node != null && 
				node.getLeft() == null && node.getRight() == null;
	}
	
	public static boolean hasTwoChildren(BTNode node) {
		return (node != null && 
				node.getLeft() != null && node.getRight() != null);
	}
	
	public static boolean hasOneChild(BTNode node) {
		if(node != null) {
			if(node.getLeft() == null && node.getRight() != null)
				return true;
			else if (node.getLeft() != null && node.getRight() == null)
				return true;
		}
		return false;
	}
	
	public static BTNode getOneChild_LeftOrRight(BTNode node) {
		if(isLeaf(node) || hasTwoChildren(node)) {//Invalid Request
			return null;
		}
		
		return (node.getLeft() == null) ? node.getRight() : node.getLeft();
	}
}
