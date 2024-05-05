package com.guru.concepts.greedy;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindromicNumber {
	public static void main(String[] args) {
		LargestPalindromicNumber lpn = new LargestPalindromicNumber();
		String num = "5736732";
		System.out.println(lpn.largestPalindromic(num));
	}

	private String largestPalindromic(String num) {
        if(num.length() == 1) {
            return num;
        }
        int[] numCount = new int[10];
        int i=0, j=0, k=0, single=Integer.MIN_VALUE;
        List<Integer> ls = new ArrayList<>();
        for(i=0 ; i<num.length() ;i++) {
            numCount[num.charAt(i)-'0']++;
        }
        if(numCount[0] == num.length()) { // if all zeros
            return "0";
        }
        for(i=numCount.length-1 ; i>=0 ; i--) {
            if(numCount[i] == 1 && single==Integer.MIN_VALUE) {
                single = i;
                if(ls.isEmpty()) {
                    ls.add(i);
                }
                else {
                    ls.add(ls.size()/2,i);
                }
            }
            else if(i==0 && ls.size() < 2) {
                break;
            }
            else if(numCount[i] > 1) {
                j = numCount[i];
                while(j>1) {
                    if(ls.isEmpty()){
                        ls.add(i);
                        ls.add(i);
                        k++;
                    }
                    else if(ls.size() == 1) {
                        ls.add(0,i);
                        ls.add(i);
                        k++;
                    }
                    else {
                        ls.add(k,i);
                        ls.add(ls.size()-k, i);
                        k++;
                    }
                    j--;
                    j--;
                }
            }
        }

        return ls.stream().map(a->a+"").reduce("",(c,d)->c+d);
    }
}
