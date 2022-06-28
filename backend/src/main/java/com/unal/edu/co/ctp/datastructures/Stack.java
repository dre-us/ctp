package com.unal.edu.co.ctp.datastructures;

public class Stack<T> {

	private int size;
	private T[] arr;

	private static final int N = 100;

	public Stack() {
		size = 0;
		arr = (T[]) new Object[N];
	}

	public Stack(int capacity) {
		if (capacity <= 0)
			throw new RuntimeException("Capacity must be positive.");
		size = 0;
		arr = (T[]) new Object[capacity];
	}

	public void push(T elem) {
		shrink();
		arr[size++] = elem;
	}

	public void pop() {
		if (size == 0)
			throw new RuntimeException("Stack empty.");
		--size;
	}

	public T peek() {
		if (size == 0)
			throw new RuntimeException("Stack empty.");
		return arr[size-1];
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public T get(int idx) {
		if (idx < 0 || idx >= size)
			throw new RuntimeException("Index out of range.");
		return arr[idx];
	}

	private void shrink() {
		if (100 * size < 75 * arr.length) return;
		T[] tmp = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < size; ++i)
			tmp[i] = arr[i];
		arr = tmp;
	}
}
