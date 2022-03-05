package com.guru.general;

import java.util.ArrayList;
import java.util.List;

class Pallindrome {
	
	public static void main(String[] args) {
		String s = "babad";
		Pallindrome p = new Pallindrome();
		System.out.println(p.longestPalindrome(s));
	}
	
    public String longestPalindrome(String s) {
        if(s==null || s.isEmpty()) {
            return "";
        }
        String[] tokens = s.split("");
        int max = 1;
        String ms = null;
        List<String> ls = new ArrayList<>();
        for(int i=0;i<tokens.length-1;i++) {
            ls.add(tokens[i]);
            for(int j=i+1;j<tokens.length;j++) {
                ls.add(tokens[j]);
                if(isPallindrome(ls)) {
                    if(ls.size() > max) {
                    	max = ls.size();
                        ms = ls.stream().reduce("",String::concat);
                    }
                }
            }
            ls.clear();
        }
        
        return ms;
    }
    
    private boolean isPallindrome(List<String> ls) {
        if(ls.size() == 1) {
            return true;
        }
        for(int i=0;i<ls.size()/2;i++) {
            if(ls.get(i).equals(ls.get(ls.size()-1-i))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}