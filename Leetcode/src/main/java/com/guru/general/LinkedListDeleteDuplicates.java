package com.guru.general;

public class LinkedListDeleteDuplicates {
	public static void main(String[] args) {
		LinkedListDeleteDuplicates lls = new LinkedListDeleteDuplicates();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		ListNode uniq = lls.deleteDuplicates(node);
		System.out.println(uniq.val +"    "+uniq.next);
	}

	private ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode start = head;
        ListNode root = null;
        ListNode leaf = null;
        while(start != null) {
            ListNode next = start.next;
            if((prev == null || start.val != prev.val) && 
                (next == null || start.val != next.val)) {
                if(root == null) {
                    root = start;
                    leaf = start;
                }
                else {
                    leaf.next = start;
                    leaf = leaf.next;
                }
            }
            prev = start;
            start = start.next;
        }
        
        return root;
    }
}

 class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
