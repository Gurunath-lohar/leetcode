package com.guru.general;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. 
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class SkipNumbers {
	public static void main(String[] args) {
		SkipNumbers sn = new SkipNumbers();
		int[] nums = {3,2,1};
		System.out.println(sn.jump(nums));
	}

	public int jump(int[] nums) {
		if(nums.length == 1) {
            return 0;
        }
        else if(nums.length == 2) {
            return 1;
        }
        List<Integer> ls = new ArrayList<>();
        int min = Integer.MAX_VALUE;        
        int i=1;
        int j=0;
        while(i<nums.length-1) {
            ls.add(nums[0]);
            j=i;
            while(j<nums.length-1) {
                if(nums[j] < nums.length-1-j) {
                    ls.add(nums[j]);
                }
                else if(nums[j] >= nums.length-1-j) {
                    ls.add(nums[j]);
                    if(ls.size() < min) {
                        min = ls.size();
                    }
                    break;
                }
                j++;
            }
            ls.clear();
            i++;
        }
        
        return min;
    }
    
    private void minSkips(int[] nums, int start, int steps, int hops, List<Integer> min) {
        if(steps > nums.length - 1) {
            return;
        }
        else if(steps == nums.length - 1) {
            if(min.isEmpty() || hops < min.get(0)) {
            	if(min.isEmpty()) {
            		min.add(hops);
            	}
            	else {
            		min.set(0, hops);
            	}             
            }
        }
        else {
        	for(int i=start;i<nums.length;i++) {
                minSkips(nums, i+1, nums[i] , hops+1, min);
            }
        }
    }
}
