package com.unal.edu.co.ctp.datastructures;

public class AVL<T extends Comparable<? super T>> {

	private class Node<T extends Comparable<? super T>> {

		private T key;
		private int height;
		private Node<T> left;
		private Node<T> right;
		private Node<T> parent;

		public Node() {	}

		public Node(T key, Node<T> parent) {
			this.key = key;
			this.parent = parent;
			this.height = 1;
		}
	}

	private int size;
	private Node<T> root;

	public AVL() {
		size = 0;
		root = null;
	}

	public T find(T key) {
		Node<T> node = find(key, root);
		if (node != null) return node.key;
		return null;
	}

	private Node<T> find(T key, Node<T> root) {
		if (root == null) return null;
		int value = root.key.compareTo(key);
		if (value > 0 && root.left != null)
			return find(key, root.left);
		if (value < 0 && root.right != null)
			return find(key, root.right);
		return root;
	}

	private void insert(T key) {
		if (root == null) {
			root = new Node<T>(key, null);
		} else {
			Node<T> node = find(key, root);
			int value = node.key.compareTo(key);
			if (value > 0)
				node.left = new Node<T>(key, node);
			else if (value < 0)
				node.right = new Node<T>(key, node);
		}
	}

	public void insertAVL(T key) {
		insert(key);
		Node<T> node = find(key, root);
		rebalance(node);
	}

	private void rebalance(Node<T> root) {
		Node<T> parent = root.parent;
		if (height(root.left) > height(root.right) + 1)
			rebalanceRight(root);
		else if (height(root.right) > height(root.left) + 1)
			rebalanceLeft(root);
		adjustHeight(root);
		if (parent != null) rebalance(parent);
	}

	private void rebalanceRight(Node<T> root) {
		Node<T> left = root.left;
		if (height(left.right) > height(left.left))
			rotateLeft(left);
		rotateRight(root);
	}

	private void rebalanceLeft(Node<T> root) {
		Node<T> right = root.right;
		if (height(right.left) > height(right.right))
			rotateRight(right);
		rotateLeft(root);
	}

	private void rotateRight(Node<T> X) {
		Node<T> P = X.parent;
		Node<T> Y = X.left;
		Node<T> B = Y.right;
		Y.parent = P;
		if (P == null) root = Y;
		if (P != null && P.left == X)
			P.left =  Y;
		else if (P != null && P.right == X)
			P.right = Y;
		X.parent = Y;
		Y.right = X;
		if (B != null) B.parent = X;
		X.left = B;
		adjustHeight(X);
		adjustHeight(Y);
	}

	private void rotateLeft(Node<T> Y) {
		Node<T> P = Y.parent;
		Node<T> X = Y.right;
		Node<T> B = X.left;
		X.parent = P;
		if (P == null) root = X;
		if (P != null && P.left == Y)
			P.left = X;
		else if (P != null && P.right == Y)
			P.right = X;
		Y.parent = X;
		X.left = Y;
		if (B != null) B.parent = Y;
		Y.right = B;
		adjustHeight(Y);
		adjustHeight(X);
	}

	private void adjustHeight(Node<T> root) {
		int left = height(root.left);
		int right = height(root.right);
		root.height = 1 + max(left, right);
	}

	private int max(int a, int b) {
		return a < b ? b : a;
	}

	private int height(Node<T> node) {
		if (node == null) return 0;
		return node.height;
	}

	public void print() {
		print(root);
	}

	private void print(Node<T> root) {
		if (root == null) return;
		print(root.left);
		System.out.print(root.key.toString() + " ");
		print(root.right);
	}
}
