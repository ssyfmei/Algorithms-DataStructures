package com.yifeng.algorithm.sorting;

public class InsertionSort implements Sort {
	public void sort(int[] a) 
	{
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int lo, int hi) {
		for(int i = lo + 1; i <= hi; i++) {
			int tmp = a[i];
			int idx = i;
			while(idx > 0 && a[idx - 1] > tmp) {
				a[idx] = a[idx - 1];
				idx--;
			}
			a[idx]=tmp;
		}
		
	}
}
