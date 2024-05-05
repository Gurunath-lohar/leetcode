package com.guru.concepts.greedy;

public class CheckParanthesis {
	public static void main(String[] args) {
		String s = "()((()()))";
		String[] p = s.split("");
		int j=0;
		int k=0;
		while(k<p.length) {
			if(p[k].equals("(")) {
				j++;
			}
			else {
				j--;
			}
			k++;
		}
		System.out.println(j==0);
	}

}
