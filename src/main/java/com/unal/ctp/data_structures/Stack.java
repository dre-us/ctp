package com.unal.ctp.data_structures;

public class Stack<T> extends ArrayList<T> {

	public Stack() {

	}

	public int obtainSize() {
		return super.size();
	}

	public T top() {
		return super.get(obtainSize() -1);
	}

	public T pop() {
		T p = super.get(obtainSize() -1);
		super.delete(obtainSize() -1);
		return p;
	}

	public T push(T p) {
		super.insert(p);
		return p;
	}

	public void print(Stack<T> p) {
		while (!empty()) {
			System.out.println((p.top()));
			p.pop();
		}
	}

	public static void main (String[] args){
		Stack<String> stack = new Stack<String>();
		stack.push("Uno");
		stack.push("dos");
		stack.push("tres");
		stack.push("cuatro");
		System.out.println(stack.obtainSize());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		stack.print(stack);
	}
}
