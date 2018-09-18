package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Stack<Item> {
	
	private int size;
	private Node first;
	
	// Inner class here to hid implementation
    private class Node {
        private Item item;
        private Node next;
    }
	
    public LinkedStack() {
		super();
		this.size = 0;
		this.first = null;
	}
    
	@Override
	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
			size--;
			Item top = first.item;
			this.first = first.next;
			return top;
		}
	}
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException();
		return first.item;
	}
	@Override
	public void push(Item item) {
		Node cur = new Node();
		cur.item = item;
		cur.next = first;
		first = cur;
		size++;
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
			Node cur = first;
			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public Item next() {
				if(!hasNext()) throw new NoSuchElementException();
				Item val = cur.item;
				cur = cur.next;
				return val;
			}
			
		};
	}

}
