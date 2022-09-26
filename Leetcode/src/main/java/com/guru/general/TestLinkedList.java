package com.guru.general;

public class TestLinkedList {
	public static void main(String[] args) {
		int i=1;
		Node root = null;
		Node node = null;
		while(i<=10) {
			if(root == null) {
				root = new Node(i);
				node = root;
			}
			else {
				node.next = new Node(i);
				node = node.next;
			}
			i++;
		}
		// find mid point
		Node node1 = root;
		Node node2 = root;
		while(node1 != null) {
			node1 = node1.next != null ? node1.next.next : null;
			if(node1 != null) {
				node2 = node2.next;
			}
		}
		System.out.println(node2.val);
	}
}

class Node {
	Node next;
	int val;
	public Node(int val) {
		this.val = val;
	}
}