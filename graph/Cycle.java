package com.yifeng.algorithm.graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	public Cycle(UDGraph graph) {
		this.marked = new boolean[graph.V()];
		for(int v = 0; v < graph.V(); v++) {
			if(!marked[v]) {
				dfs(v,  -1, graph);
			}
		}
	}
	
	private boolean dfs(int v, int p, UDGraph graph) {
		marked[v] = true;
		for(int w: graph.adj(v)) {
			if(!marked[w]) {
				if(!dfs(w, v, graph))
					return false;
			} else if(w != p) {
				hasCycle = true;
				return false;
			}
		}
		return true;
	}
	
	public boolean hasCycle() {
		return hasCycle;
	}
}
