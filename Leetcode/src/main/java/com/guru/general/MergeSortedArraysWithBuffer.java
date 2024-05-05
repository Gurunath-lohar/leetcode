package com.guru.general;

// merge sorted arrays with buffer
public class MergeSortedArraysWithBuffer {
	public static void main(String[] args) {
		int[] a = {1,5,0,0,0,0,0};//last 3 digits is a buffer
		int[] b = {2,3,4,6,7};
		int lenA = 2-1;
		int lenB = 5-1;
		int m = 6;
		int i=lenA, j=lenB;
		while(i>=0 && j>=0) {
			if(a[i] < b[j] ) {
				a[m] = b[j];
				j--;
			}
			else {
				a[m] = a[i];
				i--;
			}
			m--;
		}
		for(int k : a) {
			System.out.println(k);
		}
	}
}
