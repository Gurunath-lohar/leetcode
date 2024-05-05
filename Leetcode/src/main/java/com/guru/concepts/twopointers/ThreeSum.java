package com.guru.concepts.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> result = ts.threeSum(nums);
		System.out.println(result);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        findThreeSum(ls, nums, 2);

        return ls;
    }

	private void findThreeSum(List<List<Integer>>ls, int[] nums, int limit) {
        Arrays.sort(nums);
        List<String>strs = new ArrayList<>();
        for(int i=0;i<nums.length-limit;i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    if(checkDuplicate(strs, l)) {
                        ls.add(l);
                    }
                }
                else if(sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
    }
	
	private boolean checkDuplicate(List<String> strs, List<Integer> l) {
        String s = l.stream().sorted().collect(Collectors.toList()).stream().map(c -> c+"").reduce("", (a,b)-> a+b);
        if(strs.contains(s)) {
            return false;
        }
        strs.add(s);

        return true;
    }
}
