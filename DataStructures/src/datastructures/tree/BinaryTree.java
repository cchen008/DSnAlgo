package datastructures.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public Node levelOrderInsertion(int[] arr, Node root, int i) {
		if(i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;
			
			root.left = levelOrderInsertion(arr, root.left, 2 * i + 1);
			root.right = levelOrderInsertion(arr, root.right, 2 * i + 2);
		}
		
		return root;
	}
	
	public void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.val + " ");
			inOrderTraversal(node.right);
			return;
		}
	}
	
	public void postOrderTraversal(Node node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.val + " ");
			return;
		}
	}
	
	public void preOrderTraversal(Node node) {
		if(node != null) {
			System.out.print(node.val + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
			return;
		}
	}
	
	public void printLevelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.val + " ");
			
			if(temp.left != null)
				queue.add(temp.left);

			if(temp.right != null)
				queue.add(temp.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		
		BinaryTree tree = new BinaryTree();
		tree.root = tree.levelOrderInsertion(arr, tree.root, 0);
		
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
		System.out.println();
		tree.preOrderTraversal(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);
	}

}	

class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
}