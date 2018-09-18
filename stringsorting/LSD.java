package com.yifeng.algorithm.stringsorting;

public class LSD {
	// Sorting Strings of the same length
	public static void sort(String[] a, int w) {
		valid(a, w);
		int len = a.length;
		int   R = 26;
		String[] aux = new String[len];
		for(int i = w - 1; i >= 0; i--) {
			int[] count = new int[R];
			for(String str: a) {
				char ch = str.charAt(i);
				count[ch - 'a']++;
			}
			int inst = a.length;
			for(int j = 25; j >= 0; j--) {
				count[j] = inst - count[j];
				inst = count[j];
			}
			for(String str: a) {
				char ch = str.charAt(i);
				aux[count[ch - 'a']++] = str;
			}
			String[] tmp = a;a = aux;aux=tmp;
		}
	}
	
	private static void valid(String[] a, int w) {
		for(String str: a) {
			if(str.length() != w)
				throw new IllegalArgumentException();
		}
	}
	
	
	public static void sort(int[] a, int w) {
		
	}
	public static void main(String[] args) {
		String[] test = new String[] {"fdfa","erda","zcze","dzff","bgbs","fdaf","fdfa"};
		sort(test, 4);
		for(String str: test) {
			System.out.println(str);
		}
	}
}
