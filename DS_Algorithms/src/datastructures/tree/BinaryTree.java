package datastructures.tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
	TreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public TreeNode levelOrderInsertion(int[] arr, TreeNode root, int i) {
		if(i < arr.length) {
			TreeNode temp = new TreeNode(arr[i]);
			root = temp;
			
			root.left = levelOrderInsertion(arr, root.left, 2 * i + 1);
			root.right = levelOrderInsertion(arr, root.right, 2 * i + 2);
		}
		
		return root;
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.val + " ");
			inOrderTraversal(node.right);
			return;
		}
	}
	
	public void postOrderTraversal(TreeNode node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.val + " ");
			return;
		}
	}
	
	public void preOrderTraversal(TreeNode node) {
		if(node != null) {
			System.out.print(node.val + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
			return;
		}
	}
	
	public void printLevelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.val + " ");
			
			if(temp.left != null)
				queue.add(temp.left);

			if(temp.right != null)
				queue.add(temp.right);
		}
	}
	
	public void inOrderStackTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			System.out.print(root.val + " ");
			root = root.right;
		}
	}
	
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelper(root.left, root.right);
	}
	
	public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null || right == null) {
			return left == right;
		}
		if(left.val != right.val) {
			return false;
		}
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}
	
	public boolean iterIsSymmetric(TreeNode root) {
		if(root == null) return true;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root.left);
		stack.push(root.right);
		
		while(!stack.isEmpty()) {
			TreeNode rightSub = stack.pop();
			TreeNode leftSub = stack.pop();
			
			if(leftSub == null && rightSub == null) {
				continue;
			}
			if(leftSub == null || rightSub == null || rightSub.val != leftSub.val) {
				return false;
			}
			
			stack.push(leftSub.left);
			stack.push(rightSub.right);
			stack.push(leftSub.right);
			stack.push(rightSub.left);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int[] symArr = new int[] {1,2,2,3,4,4,3};
		
		BinaryTree tree = new BinaryTree();
		BinaryTree symTree = new BinaryTree();
		tree.root = tree.levelOrderInsertion(arr, tree.root, 0);
		symTree.root = tree.levelOrderInsertion(symArr, symTree.root, 0);
		
//		System.out.println("Inorder Traversal With Stack: ");
//		tree.inOrderStackTraversal(tree.root);
//		System.out.println();
//		
//		System.out.println("Inorder Traversal: ");
//		tree.inOrderTraversal(tree.root);
//		System.out.println();
//		
//		System.out.println("Post Traversal: ");
//		tree.postOrderTraversal(tree.root);
//		System.out.println();
//		
//		System.out.println("Pre Traversal: ");
//		tree.preOrderTraversal(tree.root);
//		System.out.println();
//		
//		System.out.println("LevelOrder Traversal: ");
//		tree.printLevelOrder(tree.root);
//		System.out.println();
		
		//Test isSymmetric methods
		System.out.println(tree.iterIsSymmetric(tree.root));
		System.out.println(symTree.iterIsSymmetric(symTree.root));
		
	}
}