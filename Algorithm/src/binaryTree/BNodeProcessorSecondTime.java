package binaryTree;

import java.util.Stack;

public class BNodeProcessorSecondTime {
	//错误的版本
	public static void binaryTreeVisitLnrErr(BNode root){
		if(root == null)
			return;
		
		Stack<BNode> stack = new Stack<BNode>();
		stack.push(root);
		while(root != null || !stack.empty()){
			//root = stk.peek();
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
				root = root.getLeft();
			}else {
				root = stack.pop();
				System.out.println(root.getData()+" ");
				root = stack.peek();
				if (root.getRight() != null) {
					stack.push(root.getRight());
				}
			}
		}
	}
	
	public static void binaryTreeVisitLnr(BNode root){
		if(root == null)
			return;
		
		Stack<BNode> stack = new Stack<BNode>();
		while(root != null || !stack.empty()){
			//root = stk.peek();
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			}else {
				root = stack.pop();
				System.out.println(root.getData()+" ");
				root = root.getRight();
			}
		}
	}
	
	public static void binaryTreeVisitNlr(BNode root){
		if(root == null)
			return;
		
		Stack<BNode> stack = new Stack<BNode>();
		while(root != null || !stack.empty()){
			//root = stk.peek();
			if (root != null) {
				System.out.println(root.getData()+" ");
				stack.push(root);
				root = root.getLeft();
			}else {
				root = stack.pop();
				root = root.getRight();
			}
		}
	}
	
	public static void binaryTreeVisitLrn(BNode root){
		if(root == null)
			return;
		
		Stack<BNode> stack = new Stack<BNode>();
		BNode pre = null;
		while(root != null || !stack.empty()){
			//root = stk.peek();
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			}else if(pre != stack.peek().getRight()) {
				root = stack.peek().getRight();				
				pre = null;
			}else{
				pre = stack.pop();
				System.out.println(pre.getData()+" ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BNode root = CreateBinaryTree.createTree("abdcef", "dbaecf");
		binaryTreeVisitLnr(root);
		binaryTreeVisitNlr(root);
		binaryTreeVisitLrn(root);
	}

}
