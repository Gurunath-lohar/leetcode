package com.guru.general;

import java.util.Arrays;
import java.util.Comparator;

public class InsertAndMergeIntervals {
	public static void main(String[] args) {
		InsertAndMergeIntervals iam = new InsertAndMergeIntervals();
		int[][] intervals = {{1,5}};
		int[] newInterval = {2,7};
		iam.insert(intervals, newInterval);
	}

	private int[][] insert(int[][] intervals, int[] newInterval) {
		int i=0,j=0;
        int[][] merged = new int[intervals.length+1][2];
        for(i=0;i<intervals.length;i++){
            merged[i] = intervals[i];
        }
        merged[i] = newInterval;
        Arrays.sort(merged, Comparator.comparingInt(o -> o[0]));

        return merge(merged);
    }
    
    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] merged = new int[intervals.length][2];
        merged[0] = intervals[0];
        int i=1,j=0;
        while(i<intervals.length) {
            if(merged[j][1] >= intervals[i][0] && 
              merged[j][1] <= intervals[i][1]) {
                merged[j][1] = intervals[i][1];
            }
            else if(merged[j][1] < intervals[i][0]){
                ++j;
                merged[j] = intervals[i];
            }
            else {
                i++;
                continue;
            }
            i++;
        }
        if(j+1 < intervals.length) {
            int[][] result = new int[j+1][2];
            int k=0;
            while(k<result.length) {
                result[k] = merged[k];
                k++;
            }
            return result;
        }
        
        return merged;
    }
}
