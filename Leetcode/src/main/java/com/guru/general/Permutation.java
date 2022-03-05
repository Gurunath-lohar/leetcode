package com.guru.general;

public class Permutation {
	public static void main(String[] args) {
		Permutation p = new Permutation();
		String s = "ABCD";
		StringBuilder sb = new StringBuilder();
		p.printPermutation(s,sb);
	}
	
	private void printPermutation(String s, StringBuilder sb) {
		if(s.length() == 0) {
			System.out.println(sb.toString());
		}
		else {
			for(int i=0;i<s.length();i++) {
				sb.append(s.charAt(i));
				printPermutation(s.substring(0, i) + s.substring(i+1, s.length()),sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
}


/*

ABC
ACB
BAC
BCA
CAB
CBA



*/