package com.guru.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * print all combination sums of a target number from given array of numbers
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> ls = cs.combinationSum(nums, target);
		ls.stream().forEach(System.out::println);
	}
	
	private List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        combine(ls, new ArrayList<Integer>(), nums, target, 0);
        
        return ls;
    }
    
    private void combine(List<List<Integer>> ls, List<Integer> l, int[] nums, int target, int start) {
        int sum = l.stream().reduce(0,Integer::sum);
        if(sum > target) {
            return;
        }
        else if(sum == target) {
            ls.add(new ArrayList<Integer>(l));
        }
        else {
            for(int i=start;i<nums.length;i++) {
                l.add(nums[i]);
                sum = sum + nums[i];
                combine(ls, l, nums, target, i);
                l.remove(l.size()-1);
            }
        }
    }
}
