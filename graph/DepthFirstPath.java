package com.yifeng.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstPath implements Paths {
	private boolean[] marked;
	private int[] prev;
	private final int s;
	
	public DepthFirstPath(Graph graph, int s) {
		this.s = s;
		marked = new boolean[graph.V()];
		prev = new int[graph.V()];
		dfs(graph, s);
	}
	
	private void dfs(Graph graph, int v) {
		marked[v]= true;
		for(int w: graph.adj(v)) {
			if(!marked[w]) {
				prev[w] = v;
				dfs(graph, w);
			}
		}
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		List<Integer> path = new LinkedList<>();
		for(int x = v; x != s; x = prev[x]) {
			path.add(0, x);
		}
		path.add(0, v);
		return path;
	}
}
