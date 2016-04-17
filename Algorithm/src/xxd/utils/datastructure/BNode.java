package xxd.utils.datastructure;

public class BNode {
	private char cc;
	private BNode left;
	private BNode right;
	
	public BNode(char cc, BNode left, BNode right){
		this.cc = cc;
		this.left = left;
		this.right = right;
	}
	
	public BNode(){
		this.cc = '0';
		this.left = null;
		this.right = null;
	}
	
	public BNode(char cc){
		this.cc = cc;
		this.left = null;
		this.right = null;
	}

	public BNode(char cc, BNode left){
		this.cc = '0';
		this.left = left;
		this.right = null;
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