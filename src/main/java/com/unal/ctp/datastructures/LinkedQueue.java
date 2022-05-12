package com.unal.ctp.datastructures;

public class LinkedQueue<T> extends LinkedList<T> {

	public LinkedQueue() {
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
