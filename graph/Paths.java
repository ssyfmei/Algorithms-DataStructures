package com.yifeng.algorithm.graph;

public interface Paths {
	public boolean hasPathTo(int v);	
	public Iterable<Integer> pathTo(int v);
}
