package com.guru.general;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfDuplicates {
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		PermutationOfDuplicates pod = new PermutationOfDuplicates();
		pod.permuteUnique(nums);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        permute(nums, ls, new ArrayList<Integer>(), new ArrayList<Integer>());

        return ls;
    }

    private void permute(int[] nums, List<List<Integer>> ls, List<Integer> l, List<Integer> skipIndexes) {
        if(l.size() == nums.length) {
            ls.add(new ArrayList<Integer>(l));
        }
        else {
            for(int i=0 ; i<nums.length ; i++) {
                if(skipIndexes.contains(i) || 
                    (i>0 && 
                    nums[i] == nums[i-1] && 
                    skipIndexes.contains(i-1))
                    ) {
                    continue;
                }
                skipIndexes.add(i);
                l.add(nums[i]);
                permute(nums, ls, l, skipIndexes);
                l.remove(l.size()-1);
                skipIndexes.remove(skipIndexes.size()-1);
            }
        }
    }
}
