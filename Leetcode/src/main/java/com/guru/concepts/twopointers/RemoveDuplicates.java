package com.guru.concepts.twopointers;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] a) {
		int[] args = {1,2,2,3,4,5,6,7};
		int j = 1;
		for(int i=1 ; i< args.length ; i++) {
			if(args[i] != args[i-1]) {
				args[j] = args[i];
				j++;
			}
		}
		Arrays.stream(args).forEach(System.out::println);
	}
}
