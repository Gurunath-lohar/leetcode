package com.guru.concepts;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {1,-5,3,-1,0,7,3,2};
		int c=1;
		while(c < a.length) {
			int j=c-1;
			int element = a[c];
			while(j>=0 && element < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = element;
			c++;
		}
		for(int i:a) {
			System.out.println(i);
		}
	}

}
