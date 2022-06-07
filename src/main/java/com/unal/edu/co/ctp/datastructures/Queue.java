package com.unal.edu.co.ctp.datastructures;

public class Queue<T> {

	private int start;
	private int end;
	private int size;
	private T[] arr;

	private static int N = 100;

	public Queue() {
		start = 0;
		end = 0;
		size = 0;
		arr = (T[]) new Object[N];
	}

	public Queue(int capacity) {
		if (capacity <= 0)
			throw new RuntimeException("Capacity must be positive.");
		start = 0;
		end = 0;
		size = 0;
		arr = (T[]) new Object[capacity];
	}

	private int next(int idx) {
		if (idx + 1 == arr.length) return 0;
		return idx + 1;
	}

	public void enqueue(T elem) {
		shrink();
		if (size != 0) end = next(end);
		arr[end] = elem;
		++size;
	}
 
	public T front() {
		if (size == 0)
			throw new RuntimeException("Empty queue.");
		return arr[start];
	}

	public void dequeue() {
		if (size == 0)
			throw new RuntimeException("Empty queue.");
		start = next(start);
		--size;
	}

	public boolean empty() {
		return size == 0;
	}

	private void shrink() {
		T[] tmp = (T[]) new Object[arr.length * 2];
		int k = start;
		for (int i = 0; i < size; ++i) {
			tmp[i] = arr[k];
			k = next(k);
		}
		start = 0;
		end = size - 1;
		arr = tmp;
	}
}
