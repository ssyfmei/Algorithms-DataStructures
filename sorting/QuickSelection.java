package com.yifeng.algorithm.sorting;

public class QuickSelection {
	
	public static Comparable<?> select(int[] a) {
		return a[0];
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {1,2,3};
		System.out.println(select(test));
	}

}
