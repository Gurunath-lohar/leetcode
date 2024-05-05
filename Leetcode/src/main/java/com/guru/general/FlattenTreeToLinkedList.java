package com.guru.general;

public class FlattenTreeToLinkedList {
	public static void main(String[] args) {
		FlattenTreeToLinkedList ftl = new FlattenTreeToLinkedList();
		int[] nums = {1,2,5,3,4,-1,6};
		TreeNode tn = ftl.buildTree(nums,0,nums.length-1);
		ftl.linkedlist(tn);
	}

	private TreeNode buildTree(int[] nums,int start, int end) {
		if(start<=end) {
			int mid = (start + end) / 2;
			if(nums[mid] == -1) {
				return null;
			}
			TreeNode t = new TreeNode(nums[mid]);
			t.left = buildTree(nums,start,mid-1);
			t.right = buildTree(nums,mid+1,end);
			
			return t;
		}
		
		return null;
	}
	
	private TreeNode linkedlist(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = linkedlist(root.left);
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = tmp;

        return root;
    }
}
