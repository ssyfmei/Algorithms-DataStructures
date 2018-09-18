package com.yifeng.algorithm.sorting;

import java.util.Random;

public class Util {
	public static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void shuffle(int[] a) {
		Random rand = new Random();
		for(int i = 1; i < a.length; i++) {
			int j = rand.nextInt(i + 1);
			exch(a, i, j);
		}
	}
	
	
}
