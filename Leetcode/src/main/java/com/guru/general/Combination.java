package com.guru.general;

public class Combination {

	public static void main(String[] args) {
		Combination c = new Combination();
		String s = "ABC";
		StringBuilder sb = new StringBuilder();
		c.printCombination(s, 0, sb);
	}
	
	private void printCombination(String s, int start, StringBuilder sb) {
		if(s.length() == start) {
			return;
		}
		else {
			for(int i=start ; i<s.length() ; i++) {
				sb.append(s.charAt(i));
				printCombination(s, i+1, sb);
				System.out.println(sb.toString());
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
}




/* 

AB
AC
BC

*/
