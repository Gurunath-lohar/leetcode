package com.guru.general;

import java.util.ArrayList;
import java.util.List;

public class TreeSumPaths {
	public static void main(String[] args) {
		TreeSumPaths tsm = new TreeSumPaths();
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		List<List<Integer>> paths = tsm.pathSum(root, -5);
		System.out.println(paths);
	}

	public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        compute(root, 0, target, sums, new ArrayList<Integer>());
        
        return sums;
    }
    
    private void compute(TreeNode root, int val, int target, List<List<Integer>> sums, List<Integer> ls) {
        if(root != null) {
            int t = val + root.val;
            if(t == target && root.left == null && root.right == null) {
                ls.add(root.val);
                sums.add(new ArrayList<Integer>(ls));
                ls.remove(ls.size()-1);
            }
            else if(t < target) {
                ls.add(root.val);
                compute(root.left, t, target, sums, ls);
                compute(root.right, t, target, sums, ls);
                ls.remove(ls.size()-1);
            }
        }
    }
}
