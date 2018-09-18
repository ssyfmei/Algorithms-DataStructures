package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Queue<Item> {
	private int size;
	private Node first;
	private Node last;
	
	// Inner class here to hid implementation
    private class Node {
        private Item item;
        private Node next;
    }
    public LinkedQueue() {
    	size = 0;
    	first= null;
    	last = null;
    }
    
	@Override
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
			return last.item;
		}
	}

	@Override
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
			Item val = last.item;
			last = last.next;
			size--;
			return val;
		}
	}

	@Override
	public void enqueue(Item item) {
		Node newNode = new Node();
		newNode.item = item;
		if(isEmpty()) {
			first = newNode;
			last  = first;
		} else {
			first.next = newNode;
			first = newNode;
		}
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
			Node cur = last;
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
