package com.yifeng.algorithm.searching;

import java.util.Random;

public class App {
	public static void main(String[] args) {
		RedBlackBST<Integer, String> map = new RedBlackBST<>();
		
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			int item = random.nextInt(10);
			map.put(i, Integer.toString(item));
			if(i % 3 == 0){
				map.delete(i);
			}
		}
		System.out.println(map.height());
	}
}
