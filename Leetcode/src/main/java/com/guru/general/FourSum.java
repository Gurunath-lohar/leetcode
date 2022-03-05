package com.guru.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int target = -1;
		FourSum f = new FourSum();
		System.out.println(f.fourSum(nums, target));
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadraples = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length <= 3) {
            return quadraples;
        }
        findQuadraples(nums, 0, new ArrayList<String>(), quadraples, new ArrayList<Integer>(), target);
        
        return quadraples;
    }
    
    private void findQuadraples(int[] nums, int n, List<String> quadraplesPattern, List<List<Integer>> quadraples, List<Integer> ls, int target) {
        int sum = ls.stream().reduce(0,(a,b)-> a+b);
        if(ls.size() > 4) {
            return;
        }
        if(ls.size() == 4) {            
            if(sum == target) {
                String pattern = ls.stream().map(s1 -> s1+"").reduce("", (a,b) -> a+","+b);
                if(!quadraplesPattern.contains(pattern)) {                    
                    quadraplesPattern.add(pattern);
                    List<Integer> l = new ArrayList<>(ls);
                    quadraples.add(l);
                }
            }
            return;
        }
        for(int i=n ; i<nums.length ; i++) {            
            ls.add(nums[i]);
            findQuadraples(nums, i+1, quadraplesPattern, quadraples, ls, target);
            ls.remove(ls.size()-1);
        }
    }
}
