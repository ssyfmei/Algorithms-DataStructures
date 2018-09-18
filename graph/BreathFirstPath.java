package com.yifeng.algorithm.graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstPath implements Paths {
	private int[] prev;
	private int[] layer;
	private final int s;
	
	public BreathFirstPath(Graph graph, int s) {
		this.s = s;
		prev = new int[graph.V()];
		layer= new int[graph.V()];
		bfs(graph, s);
	}
	private void bfs(Graph graph, int s) {
		Queue<Integer> queue = new LinkedList<>();
		int lay = 1; layer[s]  = lay; 
		queue.add(s);
		while(!queue.isEmpty()) {
			lay++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int v = queue.poll();
				for(int w: graph.adj(v)) {
					if(layer[w] != 0) {
					   prev [w]  = v;
					   layer[w] = lay;
					   queue.add(w);
					}
				}
			}
		}
	}
	public boolean hasPathTo(int v) {
		return layer[v] == 0;
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