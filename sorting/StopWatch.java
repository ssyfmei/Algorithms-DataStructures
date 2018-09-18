package com.yifeng.algorithm.sorting;

public class StopWatch 
{
	private long start;
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now - start)/ 1000.0; 
	}
	public void reset() {
		start = System.currentTimeMillis();
	}
}
