package com.yifeng.algorithm.sorting;

public class HeapSort implements Sort {

	public void sort(int[] a) {
		int n = a.length;
		for (int k = n/2; k >= 1; k--) {
			sink(a, k, n);
		}
		while(n > 1) {
			Util.exch(a, 0, n - 1);
			n--;
			sink(a, 1, n);
		}
	}
	private void sink(int[] a, int k, int size) {
		while(2 * k <= size) {
			int j = 2 * k;
			if(j < size && less(a, j, j + 1) ) j++;
			if(less(a, j, k)) return;
			Util.exch(a, k-1, j-1);
			k = j;
		}
	}
	private boolean less(int[] a, int i, int j) {
		return a[i - 1] < a[j - 1];
	}

}
