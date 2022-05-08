package datastructures.tree;

public class BinarySearchTree extends BinaryTree {
	public BinarySearchTree() {
		super();
	}
	
	//Convert sorted array to BST
	public TreeNode arrToBST(int[] arr, int left, int right) {
		if(left > right) {
			return null;
		}
		
		int mid = (right + left) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		
		node.left = arrToBST(arr, left, mid - 1);
		node.right = arrToBST(arr, mid + 1, right);
		
		return node;
	}
	
	//Return true if node is in BST
	public boolean searchTreeNode(TreeNode node, int val) {
		if(node == null) return false;
		if(node.val == val) return true;
		if(val < node.val) return searchTreeNode(node.left, val);
		return searchTreeNode(node.right, val);
	}
	
	//Insert node in BST
	public TreeNode insertTreeNode(TreeNode node, int val) {
		if(node == null) {
			node = new TreeNode(val);
			return node;
		}
		
		if(val < node.val) {
			node.left = insertTreeNode(node.left, val);
		}
		else {
			node.right = insertTreeNode(node.right, val);
		}
		
		return node;
	}
	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		
		tree.root = tree.arrToBST(arr, 0, arr.length - 1);
		
		System.out.print("InOrder Traversal: ");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		
		System.out.print("PreOrder Traversal: ");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		
		System.out.println(tree.searchTreeNode(tree.root, 7));
		
		//Insert 20;
		tree.root = tree.insertTreeNode(tree.root, 20);
		//Insert 10;
		tree.root = tree.insertTreeNode(tree.root, 11);
		
		//Inorder Traversal should return nodes in non decreasing order
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.preOrderTraversal(tree.root);
		
	}
}
