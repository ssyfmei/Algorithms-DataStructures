package com.yifeng.algorithm.graph;

public class Bipartite {
	boolean[] marked;
	boolean[] color;
	boolean   isBipartite;
	public Bipartite(UDGraph graph) {
		marked = new boolean[graph.V()];
		color  = new boolean[graph.V()];
		for(int s = 0; s < graph.V(); s++) {
			if(!marked[s])
				dfs(s, graph);
		}
	}
	private boolean dfs(int v, UDGraph graph) {
		marked[v] = true;
		for(int w: graph.adj(v)) {
			if(!marked[w]) {
				color[w] = !color[v]; 
				if(!dfs(w, graph))
					return false;
			} else if(color[w] == color[v]) {
				isBipartite = false; 
				return false;
			}
		}
		return true;
	}
	
	public boolean isBipartite() {
		return isBipartite;
	}
}
