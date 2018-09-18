package com.yifeng.algorithm.sorting;

public class QuickSortThreeWay implements Sort {

	@Override
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int lo, int hi) {
		partitionThreeWay(a, lo, hi);
	}
	public void partitionThreeWay(int[] a, int lo, int hi) {
		if(lo >= hi) return;
		int lt = lo, gt = hi, i = lo + 1;
		int v = a[lt];
		while(i <= gt) {
			if(a[i] < v) { Util.exch(a, i++, lt++);}
			else if(a[i] > v) { Util.exch(a, i, gt--);}
			else { i++;}
		}
		partitionThreeWay(a, lo, lt - 1);
		partitionThreeWay(a, gt + 1 , hi);
	}
}
