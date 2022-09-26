package com.guru.tree;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=10;i>=1;i--) {
			a[10-i] = i;
		}
		Node n = new Node(a[a.length/2]);
		fillupNodes(n, a, a.length/2-2);
		List<Integer> ls = new ArrayList<>();
		inPath(ls, n);
		ls.stream().forEach(System.out::println);
	}
	private static void fillupNodes(Node n, int[] a, int i) {
		if(i > 0) {
			n.left = new Node(a[2*i+1]);
			n.right = new Node(a[2*i+2]);
			fillupNodes(n.left, a, i-1);
			fillupNodes(n.right, a, i-1);
		}
	}
	private static void inPath(List<Integer>ls, Node n) {
		if(n != null) {
			inPath(ls, n.left);
			ls.add(n.val);
			inPath(ls, n.right);
		}
	}
}

class Node {
	Node left;
	Node right;
	int val;
	public Node(int val) {
		this.val = val;
	}
}
