package com.guru.algorithms;

/*
 * In a quick pick an element anywhere and then move rest of the elements lesser ones to left and greater ones to right
 * repeat it until everything is sorted out
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,5,7,8,0,-1,4,3};
		QuickSort qs = new QuickSort();
		qs.quickSort(nums, 0, nums.length-1);
		for(int i : nums) {
			System.out.println(i);
		}
	}
	
	private void quickSort(int[] nums, int start, int end) {
		if(start < end) {
			int pivot = findPivot(nums, start, end);
			quickSort(nums, start, pivot-1);
			quickSort(nums, pivot+1, end);
		}		
	}

	private int findPivot(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start, j=start;
		while(i < end) {
			if(nums[i] < pivot) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
			i++;
		}
		nums[end] = nums[j];
		nums[j] = pivot;
		
		return j;
	}
}
