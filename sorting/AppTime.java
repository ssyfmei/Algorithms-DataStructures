package com.yifeng.algorithm.sorting;

public class AppTime {
	public static void main(String[] args) {
		String[] methods = new String[] {"BubbleSort","SelectionSort","InsertionSort","ShellSort",
				"MergeSort","MergeSortBU","QuickSort","QuickSortNew","QuickSortThreeWay", "HeapSort"};
		int N = 40000;
		int[] test0 = new int[N];
		for(int i = 0; i < N; i++) {test0[i] = i/3*3;}
		Util.shuffle(test0);
		StopWatch sw = new StopWatch();
		
		for(String md: methods) {
			Sort method = SortingManager.generate(md);
			sw.reset();
			method.sort(test0);
			System.out.println(md + ":" + sw.elapsedTime());
		}
	}
}