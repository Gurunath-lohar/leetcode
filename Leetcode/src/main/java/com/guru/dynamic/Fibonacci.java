package com.guru.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int n = 10;
		Map<Integer,Integer> m = new HashMap<>();
		for(int i=0;i<n;i++) {
			System.out.println(f.getFibonacci(i));
			//System.out.println(f.dynamicFibonacci(i,m));
			//m.clear();
		}
	}
	
	private int getFibonacci(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return getFibonacci(n-1) + getFibonacci(n-2);
	}
	
	private int dynamicFibonacci(int n, Map<Integer, Integer>m) {
		if(n==0 || n==1) {
			return n;
		}
		if(m.get(n) != null) {
			return m.get(n);
		}
		return dynamicFibonacci(n-1,m) + dynamicFibonacci(n-2,m);
	}
}