package com.guru.refresh.string;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveOuterBrackets {
	public static void main(String[] args) {
		RemoveOuterBrackets rob = new RemoveOuterBrackets();
		String s = "(()())(())";
		System.out.println(rob.removeOuterParentheses(s));
	}
	
	private String removeOuterParentheses(String s) {
        Stack<String> stck = new Stack<>();
        boolean leftDup = false;
        boolean rightDup = false;
        String[] strs = s.split("");
        for(int i=0 ; i<strs.length ; i++) {
            String top = stck.empty() ? "" : stck.peek();
            if(strs[i].equals("(")) {
                if(!top.equals(strs[i])) {
                    stck.push(strs[i]);
                }
                else {
                    leftDup = true;
                }
            }
            else {
                if(!top.equals(strs[i]) && !leftDup) {
                    stck.pop();//remove left bracket and don't add right bracket.
                    leftDup = false;
                }
                else if(!top.equals(strs[i])){
                    stck.push(strs[i]);
                }
            }
        }
        

        return stck.stream().map(s1 -> s1.toString()).collect(Collectors.joining(""));
    }

}
