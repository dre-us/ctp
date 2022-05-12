package com.unal.ctp.datastructures;

import java.io.*;

public class Tree<T> {

	private class Node<T> {

		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public Node() {
			this(null, null, null);
		}
	}

	private Node<T> root;

	public Tree() {
		this.root = new Node<T>();
	}

	public void createTree() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		createTree(br, root);
	}

	private void createTree(BufferedReader br, Node<T> root) throws IOException {
		System.out.println("Ingrese operando u operador");
		String text = br.readLine();
		root.data = (T) text;
		if (text.equals("*") || text.equals("+")) {
			root.left = new Node<T>();
			root.right = new Node<T>();
			createTree(br, root.left);
			createTree(br, root.right);
		}
	}

	public static void main(String[] args) throws IOException {
		Tree<String> tree = new Tree<String>();
		tree.createTree();
		tree.printPreOrder();
		tree.printPosOrder();
		tree.printInOrder();
	}

	private void preOrder(Node<T> node) {
		System.out.print(node.data);
		System.out.print(" ");
		if (node.left != null && node.right != null) {
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	private void posOrder(Node<T> node) {
		if (node.left != null && node.right != null) {
			posOrder(node.left);
			posOrder(node.right);
		}
		System.out.print(" ");
		System.out.print(node.data);
	}

	private void inOrder(Node<T> node) {
		if (node.left != null && node.right != null) {
			inOrder(node.left);
			System.out.print(" ");
			System.out.print(node.data);
			System.out.print(" ");
			inOrder(node.right);
		} else {
			System.out.print(" ");
			System.out.print(node.data);
			System.out.print(" ");
		}
	}


	public void printInOrder() {
		System.out.print("inorder:");
		inOrder(root);
		System.out.println();
	}

	public void printPreOrder() {
		System.out.print("preorder:");
		preOrder(root);
		System.out.println();
	}

	public void printPosOrder() {
		System.out.print("posorder:");
		posOrder(root);
		System.out.println();
	}
}
