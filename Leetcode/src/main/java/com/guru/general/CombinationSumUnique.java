package com.guru.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumUnique {
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,1};
		System.out.println(nums.length);
		CombinationSumUnique csu = new CombinationSumUnique();
		csu.combinationSum2(nums, 3);
	}

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).boxed().reduce(0,Integer::sum);
        if(sum < target) {
            return ls;
        }
        combination(ls, new ArrayList<Integer>(), nums, target, 0);
        return ls;
    }
    
    private void combination(List<List<Integer>> ls, List<Integer> l, int[] nums, int target, int start) {
    	int sum1 = 0;
        for(int j = start;j<nums.length;j++) {
            sum1+=nums[j];
        }
        int sum = l.stream().reduce(0, Integer::sum);
        if(sum+sum1 < target) {
            return;
        }
        if(sum > target) {
            return;
        }
        else if(sum == target) {
            if(!isDuplicate(ls,l)) {
                ls.add(new ArrayList<Integer>(l));
            }
            return;
        }
        else {
            for(int i=start;i<nums.length;i++) {
                l.add(nums[i]);
                combination(ls, l, nums, target, i+1);
                l.remove(l.size()-1);
            }
        }
    }
    
    private boolean isDuplicate(List<List<Integer>> ls, List<Integer> l) {
        for(int i=0;i<ls.size();i++) {
            if(ls.get(i).size() == l.size()) {
                String s1 = ls.get(i).stream().map(n->n+"").reduce("",(a,b) -> a+b);
                String s2 = l.stream().map(n->n+"").reduce("",(a,b) -> a+b);
                if(s1.equals(s2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
