package com.yifeng.algorithm.sorting;

public class MergeSortBU implements Sort {
	private static boolean aToAux = true;
	public void sort(int[] a) {
		int[] aux = new int[a.length];
		boolean dir = aToAux;
		
		for(int len = 1; len < a.length; len = len * 2) {
			for(int j = 0; j < a.length; j += 2 * len) {
				if(j + len - 1 < a.length - 1) {
					int hi = Math.min(a.length - 1, j + 2 * len-1);
					if(dir == aToAux) {
						merge(a, aux, j, hi, j + len - 1);
					} else {
						merge(aux, a, j, hi, j + len - 1);
					}
				}
			}
			dir = !dir;
		}
		if(dir != aToAux) System.arraycopy(aux, 0, a, 0, a.length);
	}
	
	private void merge(int[] aux, int[] a, int lo, int hi, int mid) {
		int i = lo;
		int j = mid + 1;
		for(int idx = lo; idx <= hi; idx++) {
			if(i > mid) {			a[idx] = aux[j++]; 
			} else if(j > hi) {		a[idx] = aux[i++]; 
			} else if(aux[i] < aux[j]){ 	a[idx] = aux[i++]; 
			} else {			a[idx] = aux[j++]; 
			}
		}
	}
	
}
