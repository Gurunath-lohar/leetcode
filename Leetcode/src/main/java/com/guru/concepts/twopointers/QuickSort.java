package com.guru.concepts.twopointers;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = {1,-5,3,-1,0,7,3,2,-7,6,8};
		qs.quickSort(a,0,a.length-1);
		for(int i:a) {
			System.out.println(i);
		}
		int[] b = {1,-5,3,-1,0,7,3,2,-7,6,8};
		int nth = 4;
		System.out.println(nth+" largest number : " + qs.nthLargest(b, b.length-nth, 0, b.length-1));
	}
	
	private void quickSort(int[] a, int start, int end) {
		if(start < end) {
			int pivot = getPivot(a, start, end);
			quickSort(a,start,pivot-1);
			quickSort(a,pivot+1,end);
		}
	}
	
	private int getPivot(int[] a, int start, int end) {
		int num = a[end];
		int i=0;
		int j=start;
		for(i=start;i<end;i++) {
			if(a[i] < num) {
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j++;
			}
		}
		a[end] = a[j];
		a[j] = num;
		
		return j;
	}
	
	private int nthLargest(int[] a, int n, int start, int end) {
		int pivot = getPivot(a, start, end);
		if(pivot == n) {
			return a[n];
		}
		else if(n > pivot) {
			return nthLargest(a, n, pivot+1, end);
		}
		else {
			return nthLargest(a, n, start, pivot-1);
		}
	}
	
}
