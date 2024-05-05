package com.guru.concepts.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestElements {
	public static void main(String[] args) {
		FindClosestElements fce = new FindClosestElements();
		int[] arr = {1,2,3,4,5};
		int k=4, x=3;
		List<Integer> result = fce.findClosestElements(arr, k, x);
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] diffs = new int[arr.length];
        int[] result = new int[k];
        int pos = 0, i=0, j=0, m=1, lowest_diff=Integer.MAX_VALUE;
        for(i=0 ; i<arr.length ; i++) {
            diffs[i] = Math.abs(arr[i] - x);
            if(diffs[i] < lowest_diff) {
                lowest_diff = diffs[i];
                pos = i;
            }
        }
        i=pos-1;
        j=pos+1;
        result[0] = arr[pos];
        while(i>=0 && j<arr.length && m<result.length) {
            if(diffs[i] <= diffs[j]) {
                result[m] = arr[i];
                i--;
            }
            else {
                result[m] = arr[j];
                j++;
            }
            m++;
        }
        while(j<arr.length && m<result.length) {
        	result[m] = arr[j];
        	m++;
        	j++;
        }
        while(i>=0 && m<result.length) {
        	result[m] = arr[i];
        	m++;
        	i--;
        }
        Arrays.sort(result);

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

}
