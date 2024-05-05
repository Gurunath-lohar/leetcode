package com.guru.recursion;

import java.util.Stack;

public class SortAStack {
	public static void main(String[] args) {
		SortAStack sas = new SortAStack();
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(0);
		st.push(1);
		st.push(3);
		st.push(2);
		st.push(4);
		sas.sort(st);
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}
	
	private Stack<Integer> sort(Stack<Integer> st) {
		if(st.size() == 1) {
			return st;
		}
		int temp = st.pop();
		sort(st);
		insert(temp,st);
		
		return st;
	}
	
	private void insert(int t, Stack<Integer> st) {
		if(st.size() == 0 || st.peek() <= t) {
			st.push(t);
		}
		else {
			int t1 = st.pop();
			insert(t,st);
			st.push(t1);
		}
	}

}
