package com.guru.general;

public class ClosestThreeSum {
	
	int close = Integer.MIN_VALUE;
    int sum1 = 0;

	public static void main(String[] args) {
		int[] a = {-1,2,1,4};
		ClosestThreeSum c = new ClosestThreeSum();
		System.out.println(c.threeSumClosest(a, 1));
	}
	
    public int threeSumClosest(int[] nums, int target) {
        findClosest(nums, target, 0, 0, 0);
        
        return sum1;
    }
    
    private void findClosest(int[] nums, int target, int size, int start, int sum) {
        if(size == 3) {
            int diff = Math.abs(target - sum);
            if(close == Integer.MIN_VALUE) {
            	close = diff;
            	sum1 = sum;
            }
            else if(close > diff) {
                sum1 = sum;
                close = diff;
            }
        }
        else {
            for(int i=start ; i< nums.length ; i++) {
                sum = sum + nums[i];
                size++;
                findClosest(nums, target, size, i+1, sum);   
                sum = sum - nums[i];
                --size;
            }
        }
    }
}
