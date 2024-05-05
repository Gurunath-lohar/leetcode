package com.guru.concepts.twopointers;

public class RotateLinkedList {
	public static void main(String[] args) {
		RotateLinkedList rls = new RotateLinkedList();
		ListNode ln = new ListNode(1);
		ListNode root = ln;
		int i=2; 
		while(i <= 5) {
			ln.next = new ListNode(i);
			ln = ln.next;
			i++;
		}
		ListNode newRoot = rls.rotateRight(root, 3);
		while(newRoot != null) {
			System.out.println(newRoot.val);
			newRoot = newRoot.next;
		}
	}
	
	public ListNode rotateRight(ListNode head, int k) {
	    int len = 1;
	    ListNode tail = head;
	    while (tail.next != null) {
	        len++;
	        tail = tail.next;
	    }
	    
	    k %= len;
	    if (k == 0) {
	        return head;
	    }
	    
	    ListNode newTail = head;
	    for (int i = 0; i < len - k - 1; i++) {
	        newTail = newTail.next;
	    }
	    
	    ListNode newHead = newTail.next;
	    newTail.next = null;
	    tail.next = head;
	    
	    return newHead;
    }

}

class ListNode {
	public ListNode next;
	public int val = 0;
	public ListNode(int val) {
		this.val = val;
	}
}
