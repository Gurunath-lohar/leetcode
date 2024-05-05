package com.guru.concepts.twopointers;

import java.util.Arrays;

public class NextGreaterElement {
	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		System.out.println(nge.nextGreaterElement(230241));
	}

	public int nextGreaterElement(int n) {
		String numString = Integer.toString(n);
        int[] digits = new int[numString.length()];
        for(int j=0; j<digits.length ; j++) {
            digits[j] = numString.charAt(j)-'0';
        }
        //find the digit from the end which is smaller than the last digit
        int i = digits.length-2;
        while(i>=0) {
            if(digits[i] < digits[i+1]) {
                break;
            }
            i--;
        }
        if(i<0) {
            return -1; // this is the largest number
        }
        //swap the digits, now the number looks bigger. But we need tofind the 
        // lowest number greater than current hence we need to sort the elements
        // from this digts in ascending order
        int t = digits[digits.length-1];
        digits[digits.length-1] = digits[i];
        digits[i] = t;
        Arrays.sort(digits, i+1, digits.length);
        String s = Arrays.stream(digits).boxed().map(m->m+"").reduce("",(a,b)->a+b);
        return Integer.parseInt(s);
    }
}
