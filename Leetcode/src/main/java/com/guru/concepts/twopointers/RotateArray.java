package com.guru.concepts.twopointers;

public class RotateArray {
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] a = {1,2,3,4,5,6,7};
		int k = 5;
		ra.rotate(a, 0, a.length-1);
		ra.rotate(a, 0, k-1);
		ra.rotate(a, k, a.length-1);
		for(int i : a) {
			System.out.println(i);
		}
	}
	
	private void rotate(int[] a, int start, int end) {
		while(start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

}
