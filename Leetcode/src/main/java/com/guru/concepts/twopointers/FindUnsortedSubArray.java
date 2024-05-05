package com.guru.concepts.twopointers;

public class FindUnsortedSubArray {
	public static void main(String[] args) {
		FindUnsortedSubArray fus = new FindUnsortedSubArray();
		int[] nums = new int[] {1,3,2,4,5};
		System.out.println(fus.findUnsortedSubarray(nums));
	}
	
	public int findUnsortedSubarray(int[] nums) {
        int prevLr = nums[0], iLr = 0, iRl = 0;
        boolean lrFound = false, rlFound = false;
        int prevRl = nums[nums.length-1];
        int i=1, j=nums.length-2;
        while(i< nums.length && j >= 0) {
            if(!lrFound && prevLr > nums[i]) {
                lrFound = true;
                iLr = i-1;
            }
            if(!rlFound && prevRl < nums[j]) {
                rlFound = true;
                iRl = j+1;
            }
            prevLr = nums[i];
            prevRl = nums[j];
            i++;
            j--;
        } 

        return iLr==iRl ? nums.length - iLr+1 : iRl - iLr +1;
    }

}
