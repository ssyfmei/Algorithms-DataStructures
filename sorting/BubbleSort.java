package com.yifeng.algorithm.sorting;

public class BubbleSort implements Sort{
	public  void sort(int[] a) 
	{
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = 0; j < a.length - i - 1; j ++) {
				if(a[j] - a[j + 1] > 0) 
				{
					Util.exch(a, j, j + 1);
				}
			}
		}
	}
}
