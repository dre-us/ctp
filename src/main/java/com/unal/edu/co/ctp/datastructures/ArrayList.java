package com.unal.edu.co.ctp.datastructures;

public class ArrayList<T> {

	private int size;
	private T[] arr;

	private static final int N = 100;

	public ArrayList() {
		size = 0;
		arr = (T[]) new Object[N];
	}

	public ArrayList(int capacity) {
		if (capacity <= 0)
			throw new RuntimeException("Capacity must be positive.");
		size = 0;
		arr = (T[]) new Object[capacity];
	}

	public void add(T elem) {
		shrink();
		arr[size++] = elem;
	}

	public T get(int idx) {
		if (idx < 0 || idx >= size)
			throw new RuntimeException("Index out of range.");
		return arr[idx];
	}

	public void set(int idx, T elem) {
		if (idx < 0 || idx >= size)
			throw new RuntimeException("Index out of range.");
		arr[idx] = elem;
	}

	public void insert(int idx, T elem) {
		if (idx < 0 || idx >= size)
			throw new RuntimeException("Index out of range.");
		shrink();
		for (int i = size; i > idx; --i)
			arr[i] = arr[i - 1];
		arr[idx] = elem;
		++size;
	}

	public void remove(int idx) {
		if (idx < 0 || idx >= size)
			throw new RuntimeException("Index out of range.");
		--size;
		for (int i = idx; i < size; ++i)
			arr[i] = arr[i + 1];
	}

	public void remove(T elem) {
		for (int i = 0; i < size; ++i)
			if (arr[i].equals(elem))
				remove(i);
	}

	public int find(T elem) {
		for (int i = 0; i < size; ++i)
			if (arr[i].equals(elem))
				return i;
		return -1;
	}

	public int size() {
		return size;
	}

	public void shrink() {
		if (100 * size < 75 * arr.length) return;
		T[] tmp = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < size; ++i)
			tmp[i] = arr[i];
		arr = tmp;
	}
}
