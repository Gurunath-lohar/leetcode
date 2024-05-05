package com.guru.general;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {3,4,5,2,1,0,-1};
		int i=0;
		int j=0;
		int n = 0;
		while(i<a.length) {
			n = a[i];
			j = i-1;
			while(j>=0 && n < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = n;
			i++;
		}
		for(int l : a) {
			System.out.println(l);
		}
	}
}
