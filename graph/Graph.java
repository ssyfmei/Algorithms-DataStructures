package com.yifeng.algorithm.graph;

public interface Graph {
	public int E();
	public int V();
	public void addEdge(int v, int w);
	public Iterable<Integer> adj(int v);
}