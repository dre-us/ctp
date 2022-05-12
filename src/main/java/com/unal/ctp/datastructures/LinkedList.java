package com.unal.ctp.datastructures;

public class LinkedList<T> {

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public Node(T data) {
			this(data, null);
		}

		public Node() {
			this(null, null);
		}
	}

	private int size;
	private Node<T> start;
	private Node<T> end;

	public LinkedList() {
		this.size = 0;
		start = null;
		end = null;
	}

	public void insertBack(T data) {
		Node<T> newNode = new Node<T>(data);
		if (!this.empty()) end.next = newNode;
		else start = newNode;
		end = newNode;
		++size;
	}

	public void insertFront(T data) {
		Node<T> newNode = new Node<T>(data, start);
		start = newNode;
		if (this.empty()) end = newNode;
		++size;
	}

	public T getFront() {
		if (this.empty()) throw new RuntimeException("List is empty.");
		return start.data;
	}

	public void deleteFront() {
		if (this.empty()) throw new RuntimeException("List is empty.");
		this.start = start.next;
		--size;
	}

	public int getSize() {
		return this.size;
	}

	public boolean empty() {
		return this.getSize() == 0;
	}
}
