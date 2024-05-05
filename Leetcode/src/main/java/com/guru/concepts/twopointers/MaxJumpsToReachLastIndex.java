package com.guru.concepts.twopointers;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxJumpsToReachLastIndex {
	public static void main(String[] args) {
		MaxJumpsToReachLastIndex mjp = new MaxJumpsToReachLastIndex();
		int[] nums = {1,3,6,4,1,2};
		int target = 2;
		System.out.println(mjp.maximumJumps(nums, target));
	}
	
	private  int maximumJumps(int[] nums, int target) {
        Queue<int[]> steps = new ArrayDeque<>();
        int[] visited = new int[nums.length];
        int i=0, j=0, jumps = Integer.MIN_VALUE;
        steps.offer(new int[]{0,nums[0],0});
        visited[0] = 1;
        while(steps.isEmpty()){
            int[] position = steps.poll();
            int step = position[0];
            int val = position[1];
            int count = position[2];
            jumps = Math.max(jumps, count);
            j = step + 1;
            while(j<nums.length) {
                int sum = nums[j] - nums[step];
                if(-target <= sum && sum <= target) {
                    steps.offer(new int[]{j,nums[j],count+1});
                }
                j++;
            }
        }

        return jumps == Integer.MIN_VALUE ? -1 : jumps;
    }

}
