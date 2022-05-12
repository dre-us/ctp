package com.unal.ctp.data_structures;

public class Stack extends ArrayList{

	public int obtainSize() {
		return super.size();
	}

	public Object peek() {
		return get(obtainSize() -1);
	}

	public Object pop() {
		Object p = get(obtainSize() -1);
		remove(obtainSize() -1);
		return p;
	}

	public Object push(Object p) {
		super.insert(p);
		return p;
	}

	public void print(Stack p) {
		while (!empty()) {
			System.out.println((p.peek()));
			p.pop();
		}
	}

	public static void main (String[] args){
		Stack stack = new Stack();
		stack.push ("Uno");
		stack.push ("dos");
		stack.push ("tres");
		stack.push ("cuatro");
		System.out.println(stack.obtainSize());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.print(stack);
	}
}
