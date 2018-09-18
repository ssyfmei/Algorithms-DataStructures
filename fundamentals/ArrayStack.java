package com.yifeng.algorithm.fundamentals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Stack<Item> {
	private static final int initialSize = 16;
	private int size;
	private Object[] items;
	
	public ArrayStack() {
		size = 0;
		items=new Object[initialSize];
	}
	
	@SuppressWarnings("unchecked")
	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException();
		Item val = (Item) items[size - 1];
		items[size - 1] = null;
		size--;
		if(size > initialSize && size <= items.length/4) 
			resize(items.length/2); 
		return val;
	}
	@Override
	public void push(Item item) {
		if(size == items.length) {
			resize(2 * items.length);
		}
		items[size]= item;
		size++;
	}
	private void resize(int capacity) {
		items = Arrays.copyOf(items, capacity);
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private int cur = size - 1;
			@Override
			public boolean hasNext() {
				return cur >= 0;
			}
			@Override
			public Item next() {
				if(!hasNext()) throw new NoSuchElementException();
				return (Item)items[cur--] ;
			}
		};
	}
	
	
	
	
}
