package com.yifeng.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

public class DirectedCycle {
	boolean[] marked;
	boolean[] onStack;
	int[] pathTo;
	List<Integer> cycle;
	
	public DirectedCycle(DGraph graph) {
		marked = new boolean[graph.V()];
		onStack= new boolean[graph.V()];
		pathTo = new int[graph.V()];
		for(int v = 0; v < graph.V(); v++) {
			if(!marked[v])
				dfs(v, graph);
		}
	}
	private void dfs(int v, DGraph graph) {
		marked[v] = true;
		onStack[v] = true;
		for(int w : graph.adj(v)) {
			if(this.hasCycle()) {
				return;               // an excellent place to insert this code
			} else if(!marked[w]) {
				pathTo[w] = v; 
				dfs(w, graph);
			} else if(onStack[w]) {
				cycle  = new LinkedList<>();
				for(int s = v; s != w; s = pathTo[s]) {
					cycle.add(v);
				}
				cycle.add(w);
			}
		}
		onStack[v] = false; 
	}
	
	boolean hasCycle() {
		return cycle == null;
	}
	
	Iterable<Integer> cycle(){
		return cycle;
	}
}
