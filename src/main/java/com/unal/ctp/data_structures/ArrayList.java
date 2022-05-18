package com.unal.ctp.data_structures;

public class ArrayList<T> {

    private T[] capacity;
    private int actualSize;

    public ArrayList() {
	actualSize = 0;
        capacity = (T[]) new Object[10];
    }

    public T get(int index) {
        if(index < actualSize){
		return capacity[index];
        } else {
		throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int idx, T obj) {
	if (idx >= size())
		throw new ArrayIndexOutOfBoundsException();
	capacity[idx] = obj;
    }

    public boolean insert(T obj){
	if (find(obj) != -1) return false;
        if(capacity.length-actualSize <= 5) {
		increaseListSize();
        }
        capacity[actualSize++] = obj;
	return true;
    }

    public boolean remove(T obj){
	int i = 0;
	for (i = 0; i < actualSize; ++i)
		if (!obj.equals(capacity[i]))
			break;
	if (i == actualSize) return false;
        while(i < actualSize){
            capacity[i] = capacity[i+1];
            capacity[i+1] = null;
            i++;
        }
        actualSize--;
	return true;
    }

    public void delete(int idx) {
	actualSize--;
    }

    public int size(){
        return actualSize;
    }

    private void increaseListSize(){
	T[] newCapacity = (T[]) new Object[capacity.length * 2];
	for (int i = 0; i < size(); ++i)
		newCapacity[i] = capacity[i];
	capacity = newCapacity;
        //capacity = Arrays.copyOf(capacity, capacity.length*2);
        //System.out.println("\nNew length: "+capacity.length);
    }

    public boolean empty() {
        return actualSize == 0;
    }

    public int find(T obj) {
	for (int i = 0; i < size(); ++i) {
		if (obj.equals(capacity[i]))
			return i;
	}
	return -1;
    }

    public boolean full() {
	return actualSize == capacity.length;
    }

    public String toString() {
	String ans = "[";
	for (int i = 0; i < this.size(); ++i) {
		 ans += this.get(i).toString();
		if (i < this.size() - 1)
			ans += ", ";
	}
	return ans;
    }
}
