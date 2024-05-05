package com.guru.concepts.twopointers;

public class SplitArrayIntoThree {

	public static void main(String[] args) {
		SplitArrayIntoThree spt = new SplitArrayIntoThree();
		int[] nums = new int[] {1,2,2,2,5,0};
		System.out.println(spt.waysToSplit(nums));
	}
	
	private int waysToSplit(int[] nums) {
        int count = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1 ; i<nums.length ; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int[] suffixSum = new int[nums.length];
        suffixSum[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2 ; i>=0 ; i--) {
            suffixSum[i] = suffixSum[i+1] + nums[i];
        }
        for(int i=0; i<nums.length-2 ; i++) {
            int sum1 = prefixSum[i];
            for(int j=i+1 ; j<nums.length-1 ; j++) {
                int sum2 = getSum(nums, i+1, j);
                if(sum1 > sum2) {
                    continue;
                }
                else {
                    int sum3 = suffixSum[j+1];
                    if(sum2 <= sum3) {
                        count++;
                    }
                } 
            }
        }
        
        return count;
    }

    private int getSum(int[] nums, int start, int end) {
        int sum = 0;
        for(int i=start ; i<=end ; i++) {
            sum+=nums[i];
        }

        return sum;
    }
}
