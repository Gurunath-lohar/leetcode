package com.guru.general;

public class SubarraySum {
	public static void main(String[] args) {
		SubarraySum ss = new SubarraySum();
		int[] nums = {-3,-2,-4,-1,-6,-5};
		System.out.println(ss.maxSubArray(nums));
	}

	private int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int data : nums){
            if(sum > 0) sum += data;
            else sum = data;
            ans = Math.max(ans, sum);
        }
        return ans;
        
    }
}
