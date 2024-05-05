package com.guru.concepts.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxBeautyOfArray {
	public static void main(String[] args) {
		MaxBeautyOfArray mba = new MaxBeautyOfArray();
		int[] nums = {52,34};
		int k = 21;
		System.out.println(mba.maximumBeauty(nums, k));
	}
	
	public int maximumBeauty(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int i=0, plus=0, minus=0;
        for(i=0 ; i<nums.length ; i++) {
            plus = nums[i] + k;
            countMap.put(plus, countMap.getOrDefault(plus,0)+1);
            minus = nums[i] - k;
            if(minus >= 0) {
                countMap.put(minus, countMap.getOrDefault(minus,0)+1);
            }
        }
        for(i=0 ; i<nums.length ; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i],0)+1);
        }
        List<Integer> counts = countMap.values().stream().sorted().collect(Collectors.toList());

        return counts.get(counts.size()-1);
    }

}
