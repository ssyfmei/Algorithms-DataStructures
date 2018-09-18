package com.yifeng.algorithm.sorting;

public class QuickSortNew implements Sort {

	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public void sort(int[] a, int lo, int hi) {
		partition(a, lo, hi);
	}
	
	public void partition(int[] a, int lo, int hi) {
		if(hi - lo < 7) {new InsertionSort().sort(a,lo,hi);return;}
		int pivot = (hi + lo) >>> 1;
		Util.exch(a, lo, pivot);
		
		int v = a[lo];
		int i = lo + 1, j = hi;
		while(i <= j) {
			while(j >= lo && a[j] >  v)  j--;
			while(i <= hi && a[i] <= v) i++;
			if(i < j) Util.exch(a, i++, j--); 
		}
		Util.exch(a, lo, j);
		partition(a, lo, j - 1);
		partition(a,  i, hi);
	}
}
