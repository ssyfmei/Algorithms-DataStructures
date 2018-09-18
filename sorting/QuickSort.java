package com.yifeng.algorithm.sorting;

public class QuickSort implements Sort{
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int lo, int hi) {
		if(hi - lo < 7) {new InsertionSort().sort(a,lo,hi);return;}
		int pivot = (hi + lo) >>> 1;
		Util.exch(a, lo, pivot);
		int gt = hi;
		int lt = lo + 1;
		while(lt <= gt) {
			if(a[lt] > a[lo]) {
				Util.exch(a, lt, gt--);
			} else {
				lt++;
			}
		}
		Util.exch(a, lo, gt);
		sort(a, lo, gt - 1);
		sort(a, lt, hi);
	}
	
	
}