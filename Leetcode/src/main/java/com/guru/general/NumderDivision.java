package com.guru.general;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumderDivision {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(Arrays.stream(nums).boxed().map(s->s+"").collect(Collectors.joining(",")));
		System.out.println(divide(-214, -1));
	}
	
	private static int divide(long dividend, long divisor) {
        int multiplier = (dividend<0 && divisor<0) || (dividend>0 && divisor>0) ?
                         1 : -1;
        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend < divisor) {
            return 0;
        }
         while((dividend - divisor)>= 0) {
            dividend -= divisor;
            result++;
        }
        
        return result*multiplier;
    }
}
