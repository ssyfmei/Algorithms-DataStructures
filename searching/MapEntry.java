package com.yifeng.algorithm.searching;

public interface MapEntry<K,V> {
	public K getKey();
	public V getValue();
	public V setValue(V val);
	public boolean equals(Object o);
	public int hashCode();
}
