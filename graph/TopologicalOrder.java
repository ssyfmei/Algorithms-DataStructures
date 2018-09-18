package com.yifeng.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopologicalOrder {
	private boolean[] marked;
	private boolean[] onStack;
	private Deque<Integer> order;
	
	public TopologicalOrder(DGraph graph) {
		marked = new boolean[graph.V()];
		onStack= new boolean[graph.V()];
		order  = new ArrayDeque<>();
		for(int v = 0; v < graph.V(); v++) {
			if(!marked[v]) {
				dfs(v, graph);
			} 
		}
	}
	private void dfs(int v, DGraph graph) {
		marked[v] = true;
		for(int w: graph.adj(v)) {
			if(hasOrder()) {
				return;
			} else if(!marked[w]) {
				dfs(w, graph);
			} else if(onStack[w]) {
				order = null;
			}
		}
		order.addFirst(v);
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean hasOrder() {
		return this.order == null;
	}
}