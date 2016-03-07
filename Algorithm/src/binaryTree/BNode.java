package binaryTree;

public class BNode {
	private char cc;
	private BNode left;
	private BNode right;
	
	BNode(){
		cc ='0';
		left = null;
		right = null;
	}
	
	BNode(char cc){
		this.cc = cc;
		left = null;
		right = null;
	}
	
	BNode(char cc, BNode left){
		this.cc = cc;
		this.left = left;
		this.right = null;
	}
	
	BNode(char cc, BNode left, BNode right){
		this.cc = cc;
		this.left = left;
		this.right = right;
	}
	
	public char getData(){
		return cc;
	}
	
	public BNode getLeft() {
		return left;
	}
	
	public BNode getRight() {
		return right;
	}
	
}
