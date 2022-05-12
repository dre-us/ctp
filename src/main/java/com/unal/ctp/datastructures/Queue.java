package com.unal.ctp.datastructures;

public class Queue<T> extends ArrayList<T> {

	public Queue(int capacity) {
		super(capacity);
	}

	public Queue() {
		super();
	}

	public void enqueue(T data) {
		this.insertBack(data);
	}

	public void dequeue() {
		this.deleteFront();
	}

	public T front() {
		return this.getFront();
	}
}
