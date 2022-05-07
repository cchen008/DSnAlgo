package datastructures.tree;

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node arrToBST(int[] arr, int left, int right) {
		if(left > right) {
			return null;
		}
		
		int mid = (right + left) / 2;
		Node node = new Node(arr[mid]);
		
		node.left = arrToBST(arr, left, mid - 1);
		node.right = arrToBST(arr, mid + 1, right);
		
		return node;
	}
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
	
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public boolean searchNode(Node node, int val) {
		if(node == null) return false;
		if(node.val == val) return true;
		if(val < node.val) return searchNode(node.left, val);
		return searchNode(node.right, val);
	}
	
	public Node insertNode(Node node, int val) {
		if(node == null) {
			node = new Node(val);
			return node;
		}
		
		if(val < node.val) {
			node.left = insertNode(node.left, val);
		}
		else {
			node.right = insertNode(node.right, val);
		}
		
		return node;
	}
	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		
		tree.root = tree.arrToBST(arr, 0, arr.length - 1);
		
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		
		System.out.println(tree.searchNode(tree.root, 7));
		
		tree.root = tree.insertNode(tree.root, 20);
		tree.root = tree.insertNode(tree.root, 11);
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		
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
}
