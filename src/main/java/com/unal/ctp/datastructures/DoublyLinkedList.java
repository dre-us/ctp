package com.unal.ctp.datastructures;

public class DoublyLinkedList<T> {

	private class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public Node() {
			this(null, null, null);
		}
	}

	private int size;
	private Node<T> sentinel;

	public DoublyLinkedList() {
		this.size = 0;
		sentinel = new Node<T>();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	public void insertBack(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.prev = sentinel.prev;
		newNode.next = sentinel;
		sentinel.prev.next = newNode;
		sentinel.prev = newNode;
		++size;
	}

	public void insertFront(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.prev = sentinel;
		newNode.next = sentinel.next;
		sentinel.next.prev = newNode;
		sentinel.next = newNode;
		++size;
	}

	public T getBack() {
		if (this.empty()) throw new RuntimeException("List empty.");
		return sentinel.prev.data;
	}

	public void deleteBack() {
		if (this.empty()) throw new RuntimeException("List empty.");
		sentinel.prev.prev.next = sentinel;
		sentinel.prev = sentinel.prev.prev;
		--size;
	}

	public T getFront() {
		if (this.empty()) throw new RuntimeException("List empty.");
		return sentinel.next.data;
	}

	public void deleteFront() {
		if (this.empty()) throw new RuntimeException("List empty.");
		sentinel.next.next.prev = sentinel;
		sentinel.next = sentinel.next.next;
		--size;
	}

	public int getSize() {
		return size;
	}

	public boolean empty() {
		return this.getSize() == 0;
	}
}
