package com.guru.algorithms;

public class SelectionSort {
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,5,7,8,0,-1,4,3};
		int i=1;
		int j=1;
		while(i<nums.length) {
			j=i-1;
			int a = nums[i];
			while(j>=0 && a<nums[j]) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = a;
			i++;
		}
		for( int k : nums) {
			System.out.println(k);
		}
	}
}
