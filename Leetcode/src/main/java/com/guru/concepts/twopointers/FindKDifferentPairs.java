package com.guru.concepts.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindKDifferentPairs {
	public static void main(String[] args) {
		FindKDifferentPairs fdp = new FindKDifferentPairs();
		int[] nums = {1,3,1,4,5};
		int k = 2;
		System.out.println(fdp.findPairs(nums, k));
	}
	
	private int findPairs(int[] nums, int k) {
        int i=0, j=1;
        Arrays.sort(nums);
        Set<String> uniquePairs = new HashSet<>();
        while(i<j && j<nums.length) {
            if(nums[j] - nums[i] < k) {
                j++;
            }
            else if(nums[j] - nums[i] > k) {
                i++;
            }
            else {
                uniquePairs.add(nums[i]+","+nums[j]);
                j++;
            }
        }

        return uniquePairs.size();
    }

}
