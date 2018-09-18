package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;

public interface Stack<Item> {
	public Item pop();
	public void push(Item item);
	public int  size();
	public boolean isEmpty();
	public Iterator<Item> iterator(); 
}
