package com.unal.ctp.datastructures;

public class ArrayList<T> {

	private static final int N = 100;

	private int length;
	private int start;
	private int end;
	private int capacity;
	private T[] array;

	public ArrayList(int capacity) {
		this.length = 0;
		this.start = 0;
		this.end = 0;
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(N);
	}

	public int size() {
		return this.length;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	public boolean full() {
		return this.size() == this.capacity;
	}

	public int find(T data) {
		for (int i = 0; i < this.size(); ++i)
			if (this.get(i).equals(data))
				return i;
		return -1;
	}

	public boolean insert(T data) {
		if (this.find(data) != -1) return false;
		this.insertBack(data);
		return true;
	}

	public boolean remove(T data) {
		int i = this.find(data);
		if (i == -1) return false;
		this.delete(i);
		return true;
	}

	public void insertBack(T data) {
		if (this.full())
			throw new RuntimeException("List is full.");
		this.insert(this.size(), data);
	}

	public T getBack() {
		if (this.empty())
			throw new RuntimeException("List is empty.");
		return this.get(this.size());
	}

	public void deleteBack() {
		if (this.empty())
			throw new RuntimeException("List is empty.");
		this.delete(this.size() - 1);
	}

	public void insertFront(T data) {
		if (this.full())
			throw new RuntimeException("List is full.");
		this.insert(0, data);
	}

	public T getFront() {
		if (this.empty())
			throw new RuntimeException("List is empty.");
		return this.get(0);
	}

	public void deleteFront() {
		if (this.empty())
			throw new RuntimeException("List is empty");
		this.delete(0);
	}

	public void insert(int idx, T data) {
		if (this.full())
			throw new RuntimeException("List is full.");
		else if (idx < 0 || idx > this.size())
			throw new RuntimeException("Index out of range.");
		this.shrink();
		int elemsToMove = this.size() - idx;
		if (elemsToMove <= idx) moveRight(idx, 1);
		else moveLeft(idx - 1, -1);
		++this.length;
		this.set(idx, data);
	}

	public void delete(int idx) {
		if (this.empty())
			throw new RuntimeException("List is empty.");
		else if (idx < 0 || idx >= this.size())
			throw new RuntimeException("Index out of range.");
		int elemsToMove = this.size() - idx;
		if (elemsToMove - 1 < idx) moveRight(idx + 1, -1);
		else moveLeft(idx - 1, 1);
		--this.length;
	}

	private void moveLeft(int idx, int step) {
		if (step != -1 && step != 1)
			throw new RuntimeException("Step cannot be different to -1 or 1");
		int curr_pos, next_pos;
		for (int i = 0; i <= idx; ++i) {
			if (step == -1) {
				curr_pos = (this.start - 1 + i + this.capacity) % this.capacity;
				next_pos = (this.start + i) % this.capacity;
			} else {
				curr_pos = (idx - i + this.capacity) % this.capacity;
				next_pos = (idx - 1 - i + this.capacity) % this.capacity;
			}
			this.array[curr_pos] = this.array[next_pos];
		}
		if (step == -1) this.start = (this.start - 1 + this.capacity) % this.capacity;
		else this.start = (this.start + 1) % this.capacity;
	}

	private void moveRight(int idx, int step) {
		if (step != -1 && step != 1)
			throw new RuntimeException("Step cannot be different to -1 or 1");
		int curr_pos, next_pos;
		for (int i = 0; i < this.size() - idx; ++i) {
			if (step == -1) {
				curr_pos = (idx - 1 + i + this.capacity) % this.capacity;
				next_pos = (idx + i + this.capacity) % this.capacity;
			} else {
				curr_pos = (this.end + 1 - i + this.capacity) % this.capacity;
				next_pos = (this.end - i + this.capacity) % this.capacity;
			}
			this.array[curr_pos] = this.array[next_pos];
		}
		if (step == -1) this.end = (this.end - 1 + this.capacity) % this.capacity;
		else this.end = (this.end + 1) % this.capacity;
	}

	public String toString() {
		String ans = "[";
		for (int i = 0; i < this.size(); ++i) {
			ans += this.get(i).toString();
			if (i < this.size() - 1)
				ans += ", ";
		}
		return ans + "]";
	}

	public T get(int idx) {
		if (idx < 0 || idx >= this.size())
			throw new RuntimeException("Index out of range.");
		return this.array[(this.start + idx) % this.capacity];
	}

	public void set(int idx, T data) {
		if (idx < 0 || idx >= this.size())
			throw new RuntimeException("Index out of range.");
		this.array[(this.start + idx) % this.capacity] = data;
	}

	public void shrink() {
		if (this.size() * 100 < this.capacity * 75) return;
		T[] newArray = (T[]) new Object[this.capacity * 2];
		for (int i = 0; i < this.size(); ++i)
			newArray[i] = this.get(i);
		this.array = newArray;
		this.start = 0;
		this.end = this.size();
	}
}
