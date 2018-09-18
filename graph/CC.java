package com.yifeng.algorithm.graph;

public class CC {
	int[] label;
	int count;
	
	public CC(UDGraph graph) {
		this.count = 0;
		this.label = new int[graph.V()];
		for(int s = 0; s < graph.V(); s++) {
			if(label[s] == 0) {
				count++;
				dfs(s, graph);
			}
		}
	}
	
	private void dfs(int s, UDGraph graph) {
		label[s] = count;
		for(int w: graph.adj(s)) {
			if(label[w] == 0) {
				dfs(w, graph);
			}
		}
	}
	
	public int label(int v) {
		return label[v];
	}
	public boolean connected(int v, int w) {
		return label(v)==label(w);
	}
	public int size() {
		return count - 1;
	}
}
