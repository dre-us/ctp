package com.unal.ctp.datastructures;

public class LinkedStack<T> extends LinkedList<T> {

	public LinkedStack() {
		super();
	}

	public void push(T data) {
		this.insertFront(data);
	}

	public T top() {
		return this.getFront();
	}

	public void pop() {
		this.deleteFront();
	}
}
