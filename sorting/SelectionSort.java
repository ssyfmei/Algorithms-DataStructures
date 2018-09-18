package com.yifeng.algorithm.sorting;

public class SelectionSort implements Sort{
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int lo, int hi) 
	{
		for(int i = lo; i <= hi; i++) {
			int idx = i;
			for(int j = i + 1; j <= hi; j++) {
				if(a[idx] > a[j]) {
					idx = j;
				}
			}
			Util.exch(a, i, idx);
		}
	}
}
