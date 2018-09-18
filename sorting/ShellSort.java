package com.yifeng.algorithm.sorting;

public class ShellSort implements Sort{
	public  void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public  void sort(int[] a, int lo, int hi) {
		int len = hi - lo + 1;
		int h = 1;
		while(h < len) h= 3 * h + 1;
		while(h > 0) {
			for(int i = lo + h; i <= hi; i+=h) {
				int idx = i;
				int tmp = a[i];
				while(idx > lo && a[idx - h] > tmp ) {
					a[idx] = a[idx - h]; 
					idx = idx - h;
				}
				a[idx] = tmp; 
			}
			h= h / 3;
		}
	}
}
