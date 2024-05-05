package com.guru.concepts.greedy;

public class MinEqualSumOfArrays {
	public static void main(String[] args) {
		MinEqualSumOfArrays mea = new MinEqualSumOfArrays();
		int[] nums1 = {12,16,0,24,9,0,0,18,16,0,27,1,29,21,1};
		int[] nums2 = {18,0,0,21,7,17,2,28,14,0,27,5,24,10};
		System.out.println(mea.minSum(nums1, nums2));
	}

	public long minSum(int[] nums1, int[] nums2) {
        int c1 = 0, c2 = 0;
        long s1 = 0, s2 = 0;
        for (int num : nums1) {
            c1 += num == 0 ? 1 : 0;
            s1 += num;
        }
        for (int num : nums2) {
            c2 += num == 0 ? 1 : 0;
            s2 += num;
        }
        return ((c1 == 0 && s1 - c2 < s2) || (c2 == 0 && s2 - c1 < s1)) ? -1 : Math.max(s1 + c1, s2 + c2);
    }
}
