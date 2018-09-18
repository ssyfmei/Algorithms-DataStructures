package com.yifeng.algorithm.graph;

public class SCC {
	private int[] id;
	private boolean[] marked;
	private int count;
	
	public SCC(DGraph graph) {
		Iterable<Integer> order = new TopologicalOrder(graph.reverse()).order();
		if(order==null) throw new IllegalArgumentException("cyclic graph");
		
		this.id = new int[graph.V()];
		this.marked = new boolean[graph.V()];
		this.count = 0;

		for(int v: order) {
			if(!marked[v])
				dfs(v, graph);
			count++;
		}
	}
	
	private void dfs(int v, DGraph graph) {
		id[v]=count; 
		marked[v]= true;
		for(int w: graph.adj(v)) {
			if(!marked[w]) {
				dfs(w, graph);
			}
		}
	}
	public boolean stronglyConnected(int v, int w) {
		return id[v]==id[w]; 
	}
	public int count() {
		return count;
	}
	public int id(int v) {
		return id[v];
	}
}