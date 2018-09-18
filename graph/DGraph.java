package com.yifeng.algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.In;

public class DGraph {
	private List<Integer>[] adj;
	private int E;
	private int V;
	
	public int E() {return E;}
	public int V() {return V;}
	
	@SuppressWarnings("unchecked")
	public DGraph(int V) {
		this.V = V;
		adj = (List<Integer>[]) new LinkedList[this.V];
		for(int i = 0; i < this.V; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public DGraph(In in) {
		this(in.readInt());
		E = in.readInt();
		for(int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
		this.E++;
	}

	public Iterable<Integer> adj(int v) {
		return new LinkedList<Integer>(adj[v]);
	}
	public DGraph reverse() {
		DGraph reverseGraph = new DGraph(this.V());
		for(int i = 0; i < this.V();i++) {
			for(int w: this.adj(i)) {
				reverseGraph.addEdge(w, i);
			}
		}
		return reverseGraph;
	}
}
