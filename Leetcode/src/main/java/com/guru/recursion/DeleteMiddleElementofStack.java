package com.guru.recursion;

import java.util.Stack;

public class DeleteMiddleElementofStack {
	public static void main(String[] args) {
		DeleteMiddleElementofStack dms = new DeleteMiddleElementofStack();
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(1);
		st.push(3);
		st.push(2);
		st.push(4);
		int k = st.size()/2+1;
		dms.remove(st,k);
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}
	
	private void remove(Stack<Integer>st, int k) {
		if(k==1) {
			st.pop();
		}
		else {
			int t = st.pop();
			remove(st,k-1);
			st.push(t);
		}
	}

}
