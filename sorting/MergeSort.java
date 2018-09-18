package com.yifeng.algorithm.sorting;

import java.util.Arrays;

public class MergeSort implements Sort {
	public void sort(int[] a) {
		int[] aux = Arrays.copyOf(a, a.length);
		sort(a, aux, 0, a.length - 1);
	}
	public void sort(int[] a, int[]aux, int lo, int hi) {
		if(lo == hi) return;
		int mid = (hi + lo) >>> 1;
		sort(aux, a, lo, mid);
		sort(aux, a, mid+1, hi);
		merge(a, aux, lo, hi, mid);
	}
	
	private void merge(int[] a, int[] aux, int lo, int hi, int mid) {
		int i = lo;
		int j = mid + 1;
		for(int idx = lo; idx <= hi; idx++) {
			if(i > mid) {				 a[idx] = aux[j++]; 
			} else if(j > hi) {			 a[idx] = aux[i++]; 
			} else if(aux[i] < aux[j]){  a[idx] = aux[i++]; 
			} else {					 a[idx] = aux[j++]; 
			}
		}
	}
}
