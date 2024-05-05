package com.guru.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
 A certain bug's home is on the x-axis at position x. Help them get there from position 0.

The bug jumps according to the following rules:

It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.

 

Example 1:

Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.

Solution :
At every step determine the next fwd position and bkwd position. If condition satisfy then add fwd and bkwd position to queue.   
At each step we save 1. Step value 2. if we can go backward(we cannot go bkwd more than once consecutively) 3. Count of steps so far until current step

 */

public class MinimumSteps {
	public static void main(String[] args) {
		MinimumSteps ms = new MinimumSteps();
		int[] forbidden = {14,4,18,1,15};
		int a = 3, b = 15, x = 9;
		System.out.println(ms.findSteps(forbidden, a, b, x));
	}
	
	private int findSteps(int[] forbidden, int a, int b, int x) {
		List<Integer> forward = new ArrayList<>();
		List<Integer> backward = new ArrayList<>();
		Queue<int[]> queue = new ArrayDeque<>();
		List<Integer> fb = Arrays.stream(forbidden).boxed().collect(Collectors.toList());
		int max = a + b + Math.max(x, Collections.max(fb));
		queue.add(new int[] {0,1,0});
		while(!queue.isEmpty()) {
			int[] position = queue.poll();
			if(position[0] == x) {
				return position[2];
			}
			int fwdPos = position[0] + a; // next fwd step
			int bkwdPos = position[0] - b; // next bkwd step
			if(fwdPos <= max && !forward.contains(fwdPos) && !fb.contains(fwdPos)) {
				forward.add(fwdPos);
				queue.add(new int[] {fwdPos, 1, position[2]+1});
			}
			
			//position[1] is test if we can jump backward.
			if(bkwdPos > 0 && position[1] == 1 && !backward.contains(bkwdPos) && !fb.contains(bkwdPos)) {
				backward.add(fwdPos);
				queue.add(new int[] {bkwdPos, 0, position[2]+1});
			}
		}
		
		return -1;
	}

}
