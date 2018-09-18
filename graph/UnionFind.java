package com.yifeng.algorithm.graph;

public class UnionFind {
	int[] parent;
	byte[] rank;
	int   count;
	
	public UnionFind(int n) {
		this.count = n;
		this.rank  = new byte[n];
		this.parent= new int[n];
		for(int i = 0; i < n; i++) {
			parent[i]=i; 
		}
	}
	
	public int find(int v) {
		while(v != parent[v]) {
			parent[v]=parent[parent[v]];
			v = parent[v];
		}
		return v;
	}
	public void union(int v, int w) {
		int vp = find(v);
		int wp = find(w);
		if(vp == wp) {
			return;
		} else if(rank[vp] > rank[wp] ){
			parent[wp] = vp;
			rank[vp]++; 
		} else if(rank[vp] < rank[wp]) {
			parent[vp] = wp; 
		} else {
			parent[wp] = vp;
			rank[vp]++;  
		}
		count--;
	}
	public int count() {
		return count;
	}
}
