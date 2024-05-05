package com.guru.general;

public class LinkedListFlip {
	public static void main(String[] args) {
		LinkedListFlip lls = new LinkedListFlip();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		ListNode flip = lls.reverseBetween(node,2,3);
		System.out.println(flip.val +"    "+flip.next.val+"    "+flip.next.next.val);
	}
	private ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = head;
        int count = 1;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode prev = null;
        ListNode leftPrev = null;
        ListNode rightPrev = null;
        while(head != null) {
            if(count == left) {
                leftPrev = prev;
                leftNode = new ListNode(head.val);
            }
            else if(count == right) {
                rightPrev = prev;
                rightNode = new ListNode(head.val);
                break;
            }
            prev = head;
            head = head.next;
            ++count;
        }
        if(leftPrev != null && rightPrev != null) {
            rightNode.next = leftPrev.next != null ? leftPrev.next.next:null;
            if(leftPrev.next == rightPrev) {
            	rightPrev = rightNode;
            }
            leftPrev.next = rightNode;
            leftNode.next = rightPrev.next != null ? rightPrev.next.next:null;
            rightPrev.next = leftNode;
        }
        if(leftPrev == null && rightPrev != null) {
            rightNode.next = root.next;
            if(root == rightPrev) {
                rightPrev = rightNode;
            }
            root = rightNode;
            leftNode.next = rightPrev.next != null ? rightPrev.next.next:null;
            rightPrev.next = leftNode;
        }
        return root;
    }
}