package com.yifeng.algorithm.fundamentals;

import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		Queue<Integer>arrayStack = new LinkedQueue<>();
		
		for(int i = 0 ; i < 10; i++) {
			arrayStack.enqueue(i);
			arrayStack.enqueue(i);
			arrayStack.dequeue();
		}
		
		Iterator<Integer> iterator = arrayStack.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(arrayStack.size());
	}
}
