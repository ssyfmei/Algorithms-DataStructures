package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item>  implements Queue<Item> {
	private static final int initialSize = 16;
	private int last;
	private int first;
	private int size;
	private Object[] items;
	
	public ArrayQueue() {
		last  = 0;
		first = -1;
		size  = 0;
		items = new Object[initialSize];
	}
	
	@SuppressWarnings("unchecked")
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException();
		else return (Item) items[last];
	}

	@SuppressWarnings("unchecked")
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
			Item val = (Item) items[last];
			items[last] = null; 
			last = (last + 1) % items.length;
			size--;
			if(size > initialSize && size < items.length/4)
				resize(items.length/2);
			return val;
		}
	}
	
	public void enqueue(Item item) {
		if(size == items.length) {
			resize(2 * items.length);
		}
		size++;
		first = (first + 1) % items.length;
		items[first] = item;
	}
	
	private void resize(int capacity) {
		Object[] a = new Object[capacity];
		for(int i = 0; i < size; i++) {
			a[i] = items[(last+i) % items.length]; 
		}
		items = a;
		last  = 0;
		first = size - 1;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private int cur = 0;
			public boolean hasNext() {
				return cur < size;
			}
			@SuppressWarnings("unchecked")
			public Item next() {
				if(!hasNext()) throw new NoSuchElementException();
				Item val = (Item)items[(cur + last) % items.length]; 
				cur++;
				return val;
			}
		};
	}
}
