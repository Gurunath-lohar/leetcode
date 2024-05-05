package com.guru.concepts;

public class MergeSort {
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] a = {1,-5,3,-1,0,7,3,2};
		ms.mergeSort(a, 0, a.length-1);
		for(int i:a) {
			System.out.println(i);
		}
	}

	private void mergeSort(int[] a, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(a, 0, mid);
			mergeSort(a, mid+1, end);
			int[] left = new int[mid-start+1];
			int[] right = new int[end-mid];
			int i=0,j=0;
			for(i=start;i<=mid;i++) {
				left[j] = a[i];
				j++;
			}
			i=0;
			j=0;
			for(i=mid+1;i<=end;i++) {
				right[j] = a[i];
				j++;
			}
			i=0;
			j=0;
			int k=start;
			while(i<left.length && j<right.length) {
				if(left[i] <= right[j]) {
					a[k] = left[i];
					k++;
					i++;
				}
				else {
					a[k] = right[j];
					k++;
					j++;
				}
			}
			while(i<left.length) {
				a[k] = left[i];
				k++;
				i++;
			}
			while(j<right.length) {
				a[k] = right[j];
				k++;
				j++;
			}
		}	
	}
}
