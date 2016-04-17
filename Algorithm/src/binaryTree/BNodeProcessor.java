package binaryTree;

import java.util.Stack;

import xxd.utils.datastructure.BNode;

public class BNodeProcessor {
    private static BNode a,b,c,d,e,f,g,h,i;
    
    public static void initNode() {
    	g = new BNode('G');
    	h = new BNode('H');
    	e =new BNode('E', g, h);
    	i =new BNode('I');
    	f =new BNode('F', null, i);
    	c =new BNode('C', e, f);
    	d =new BNode('D');
    	b =new BNode('B', d);
    	a =new BNode('A', b, c);
	}
    
    public static void print(char cc) {
		System.out.print(cc+" ");
	}
    
    //递归方式遍历的方法
    public static void visitTreeRecursiveNlr(BNode root) {
		if(null != root){
			print(root.getData());
			visitTreeRecursiveNlr(root.getLeft());
			visitTreeRecursiveNlr(root.getRight());
		}
	}
    public static void visitTreeRecursiveLnr(BNode root) {
		if(null != root){
			visitTreeRecursiveLnr(root.getLeft());
			print(root.getData());
			visitTreeRecursiveLnr(root.getRight());
		}
	}
    public static void visitTreeRecursiveLrn(BNode root) {
		if(null != root){
			visitTreeRecursiveLrn(root.getLeft());
			visitTreeRecursiveLrn(root.getRight());
			print(root.getData());
		}
	}
    
    //非递归遍历方法
    public static void visitTreeNonRecursiveNlr(BNode root) {
    	Stack<BNode> s = new Stack<>();
		while(null != root || !s.isEmpty()){
			if(null != root){
				print(root.getData());
				s.push(root);
				root = root.getLeft();
			}else{
				root = s.pop();
				root = root.getRight();
			}
		}
	}
    
    public static void visitTreeNonRecursiveLnr(BNode root) {
    	Stack<BNode> s = new Stack<>();
		while(null != root || !s.isEmpty()){
			if(null != root){
				s.push(root);
				root = root.getLeft();
			}else{
				root = s.pop();
				print(root.getData());
				root = root.getRight();
			}
		}
	}
    
    public static void visitTreeNonRecursiveLrn(BNode root) {
    	Stack<BNode> s = new Stack<>();
    	BNode pre = null;
		while(null != root || !s.isEmpty()){
			if(null != root){
				s.push(root);
				root = root.getLeft();
			}else if (pre != s.peek().getRight()) {
				root = s.peek().getRight();
				pre = null;
			}else{
				pre = s.pop();
				print(pre.getData());
			}
		}
	}
    
    public static void main(String[] args) {
    	initNode();
    	BNode root = a;
    	System.out.print("先序遍历： ");
    	visitTreeRecursiveNlr(root);
    	System.out.println();
    	System.out.print("中序遍历：  ");
    	visitTreeRecursiveLnr(root);
    	System.out.println();
    	System.out.print("后序遍历：  ");
    	visitTreeRecursiveLrn(root);
    	System.out.println();
    	
    	System.out.print("非递归先序遍历： ");
    	visitTreeNonRecursiveNlr(root);
    	System.out.println();
    	System.out.print("非递归中序遍历：  ");
    	visitTreeNonRecursiveLnr(root);
    	System.out.println();
    	System.out.print("非递归后序遍历：  ");
    	visitTreeNonRecursiveLrn(root);
    	System.out.println();
	}
    
}
