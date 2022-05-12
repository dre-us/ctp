package com.unal.ctp.datastructures;

public class Stack<T> extends ArrayList<T> {

	public Stack(int capacity) {
		super(capacity);
	}

	public Stack() {
		super();
	}

	public void push(T data) {
		this.insertBack(data);
	}

	public T top() {
		return this.getBack();
	}

	public void pop() {
		this.deleteBack();
	}
}
