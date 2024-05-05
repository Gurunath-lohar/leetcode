package com.guru.general;

public class BuildBinarySearchTree {
	public static void main(String[] args) {
		BuildBinarySearchTree bbst = new BuildBinarySearchTree();
		int[] values = {1,2,3,4,5,6,7};
		TreeNode t = bbst.buildTree(values, 0, values.length-1);
		bbst.printBstTree(t);
	}
	
	private TreeNode buildTree(int[] values, int start, int end) {
		if(start <= end) {
			int mid = (start + end)/2;
			TreeNode root = new TreeNode(values[mid]);
			root.left = buildTree(values, start, mid-1);
			root.right = buildTree(values, mid+1, end);
			return root;
		}
		
		return null;
	}
	
	private void printBstTree(TreeNode root) {
		if(root != null) {
			printBstTree(root.left);
			System.out.println(root.val);
			printBstTree(root.right);
		}
	}

}
