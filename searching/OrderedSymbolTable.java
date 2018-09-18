package com.yifeng.algorithm.searching;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> 
			extends SymbolTable<Key, Value> {
	public Key min();
	public Key max();
	public Key floor(Key key);
	public Key ceiling(Key key);
	public int rank(Key key);
	public Key select(int k);
	
	public default void deleteMin() {delete(min());}
	public default void deleteMax() {delete(max());}
	public default int size(Key lo, Key hi) {
		if(hi.compareTo(lo) < 0) return 0;
		else if(containsKey(hi)) return rank(hi)-rank(lo)+1;
		else return rank(hi)-rank(lo);
	}
	public default Iterable<Key> keys(){return keys(min(), max());}
	public Iterable<Key> keys(Key lo, Key hi);
}
