package com.mingyangdai;

import java.util.LinkedList;

/**
 * @author mingyang.dai
 * @since 16/10/23
 */
class MyStack {
	LinkedList<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.empty();
		stack.pop();
		stack.empty();
	}
	
	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
	}
	
	// Removes the element on top of the stack.
	public void pop() {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Integer size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			temp.add(queue.remove(0));
		}
		queue = temp;
	}
	
	// Get the top element.
	public int top() {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Integer size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			temp.add(queue.remove(0));
		}
		int top = queue.remove(0);
		temp.add(top);
		queue = temp;
		return top;
	}
	
	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
