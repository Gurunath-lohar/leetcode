package com.guru.concepts;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
	public static void main(String[] args) {
		//nSum();
		permutation();
	}
	
	private static void nSum() {
		int [] nums = {1,2,-1,-2,0,1,-1};
		int size = 3;
		int target = 0;
		List<List<Integer>> ls = new ArrayList<>();
		nSum(nums, size, target, 0, ls, new ArrayList<Integer>());
		ls.stream().forEach(System.out::println);
	}
	
	private static void nSum(int [] nums, int size, int target, int start, List<List<Integer>> ls, List<Integer> l) {
		if(l.size() == size) {
			if( l.stream().reduce(0, (a,b) -> a+b) == 0) {
				ls.add(new ArrayList<Integer>(l));
			}
			return;
		}
		else {
			for(int i=start ; i< nums.length ; i++) {
				l.add(nums[i]);
				nSum(nums, size, target, i+1, ls, l);
				l.remove(l.size()-1);
			}
		}
	}
	
	private static void permutation() {
		int [] nums = {1,2,3};
		List<List<Integer>> ls = new ArrayList<>();
		permutation(ls, new ArrayList<Integer>(), nums);
		ls.stream().forEach(System.out::println);
	}
	
	private static void permutation(List<List<Integer>> ls, List<Integer> l, int[] nums) {
		if(nums.length == 0) {
			ls.add(new ArrayList<Integer>(l));
			return;
		}
		else {
			for(int i=0;i<nums.length;i++) {
				l.add(nums[i]);
				int[] nums1 = new int[nums.length-1];
				int k = 0;
				for(int j=0;j<nums.length;j++) {
					if(j==i) {
						continue;
					}
					nums1[k] = nums[j];
					k++;
				}
				permutation(ls, l, nums1);
				l.remove(l.size()-1);
			}
		}
	}
}
