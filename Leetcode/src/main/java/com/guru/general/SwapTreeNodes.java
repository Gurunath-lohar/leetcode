package com.guru.general;

import java.util.ArrayList;
import java.util.List;

public class SwapTreeNodes {
	List<TreeNode> nodes = new ArrayList<>();
    TreeNode firstNode = null;
    TreeNode secondNode = null;
	public static void main(String[] args) {
		SwapTreeNodes stn = new SwapTreeNodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		stn.recoverTree(root);
		System.out.println(root.val+"  "+root.left.val+"  "+root.left.right.val);
	}

    public void recoverTree(TreeNode root) {
        checkTree(root);
        firstNode = findFirstNode(secondNode);
        int t = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = t;
    }
    
    private void checkTree(TreeNode root) {
        if(root == null) {
            return;
        }
        checkTree(root.left);
        if(!nodes.isEmpty() && root.val < nodes.get(nodes.size()-1).val) {
            secondNode = root;
        }
        nodes.add(root);
        checkTree(root.right);
    }
    
    private TreeNode findFirstNode(TreeNode node) {
        TreeNode t = null;
        int i=nodes.size()-1;
        while(i>=0) {
            if(node.val > nodes.get(i).val) {
                t = nodes.get(i+1);
                break;
            }
            --i;
        }
        if(t == null) {
        	t = nodes.get(0);
        }
        
        return t;
    }

}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
