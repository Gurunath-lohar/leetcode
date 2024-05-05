package com.guru.concepts.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckMinSumInts {

	public static void main(String[] args) {
		CheckMinSumInts cms = new CheckMinSumInts();
		int[] nums = {5,6};
		System.out.println(cms.minimalKSum(nums, 6));
	}
	
	public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = 0;
        int intAppends = k;
        long rec = 0;
        long sum = 0;
        List<Long> ls = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++) {
            int n = nums[i] - prev;
            if(n > 1 && intAppends > 0) {
                rec = prev;
                while(n > 0 && intAppends > 0) {
                    rec += 1;
                    if(rec < nums[i]) {
                        sum += rec;
                        n--;
                        intAppends--;
                    }
                    else {
                        break;
                    }
                }
            }
            prev = nums[i];
            ls.add(sum) ;
            sum = 0;
        }
        rec = intAppends > 0 ? nums[nums.length-1] : 0;
        while(intAppends > 0) {
            rec += 1;
            sum += rec;
            intAppends--;
        }
        return ls.stream().mapToLong(a -> a).sum()+sum;
    }
}
