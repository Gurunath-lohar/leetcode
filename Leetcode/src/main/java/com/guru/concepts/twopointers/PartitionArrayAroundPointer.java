package com.guru.concepts.twopointers;

public class PartitionArrayAroundPointer {
	public static void main(String[] args) {
		int[] nums = {9,12,5,10,14,3,10};
		int pivot = 10;
		int slowpointer = 0, fastpointer = 0;
        while(fastpointer < nums.length) {
            if(nums[fastpointer] <= pivot) {
                int tmp = nums[slowpointer];
                nums[slowpointer] = nums[fastpointer];
                nums[fastpointer] = tmp;
                slowpointer++;
            }
            fastpointer++;
        }
        for(int i : nums)
        System.out.println(i);
	}

}
