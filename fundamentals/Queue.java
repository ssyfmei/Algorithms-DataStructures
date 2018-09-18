package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;

public interface Queue<Item> {
	public Item peek();
	public Item dequeue();
	public void enqueue(Item item);
	public int  size();
	public boolean isEmpty();
	public Iterator<Item> iterator(); 
}
