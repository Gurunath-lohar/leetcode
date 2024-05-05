package com.guru.algorithms;

public class MergeSort {
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,5,7,8,0,-1,4,3};
		MergeSort ms = new MergeSort();
		ms.mergeSort(nums, 0, nums.length-1);
		for(int i : nums) {
			System.out.println(i);
		}
	}

	private void mergeSort(int[] nums, int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid+1, end);
			int[] left = new int[mid-start+1];
			int[] right = new int[end-mid];
			int i=0, j=0;
			for(i=start; i<=mid ; i++) {
				left[j] = nums[i];
				j++;
			}
			j=0;
			for(i=mid+1; i<=end ; i++) {
				right[j] = nums[i];
				j++;
			}
			i=0;
			j=0;
			int k=start;
			while(i<left.length && j<right.length) {
				if(left[i] < right[j]) {
					nums[k] = left[i];
					i++;
				}
				else {
					nums[k] = right[j];
					j++;
				}
				k++;
			}
			while(i<left.length) {
				nums[k] = left[i];
				i++;
				k++;
			}
			while(j<right.length) {
				nums[k] = right[j];
				j++;
				k++;
			}
		}
	}
}
