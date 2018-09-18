package com.yifeng.algorithm.searching;


public interface SymbolTable<Key, Value> {
	public void put(Key key, Value value);
	public Value get(Key key);
	public void delete(Key key);
	public boolean containsKey(Key key);
	public boolean isEmpty();
	public int size();
	public Iterable<Key> keys(); 
}
