package com.yifeng.algorithm.sorting;

public class SortingManager {
	public static Sort generate(String str) {
		if(str.equals("BubbleSort")) {
			return new BubbleSort();
		} else if(str.equals("SelectionSort")) {
			return new SelectionSort();
		} else if(str.equals("InsertionSort")) {
			return new InsertionSort();
		} else if(str.equals("ShellSort")) {
			return new ShellSort();
		} else if(str.equals("MergeSort")) {
			return new MergeSort();
		} else if(str.equals("MergeSortBU")){
			return new MergeSortBU();
		} else if(str.equals("QuickSort")){
			return new QuickSort();
		} else if(str.equals("QuickSortNew")){
			return new QuickSortNew();
		} else if(str.equals("QuickSortThreeWay")){
			return new QuickSortThreeWay();
		} else if(str.equals("HeapSort")){
			return new HeapSort();
		} else {
			throw new IllegalArgumentException("Unknown Sorting Method");
		}
	}
}
