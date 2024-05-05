package com.guru.concepts.twopointers;

public class TwoSum {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int target = 7;
		int l=0;
		int r=a.length-1;
		int[] b = new int[2];
		while(l<r) {
			int sum = a[l] + a[r];
			if(sum == target) {
				b[0] = l;
				b[1] = r;
				break;
			}
			else if(sum < target) {
				l++;
			}
			else {
				r--;
			}
		}
		for(int i:b) {
			System.out.println(i);
		}
	}

}
