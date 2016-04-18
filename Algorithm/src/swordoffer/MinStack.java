package swordoffer;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> s = new Stack<Integer>();
	private Stack<Integer> smin = new Stack<Integer>();
	
	public void push(int n){
		s.push(n);
		if(!smin.empty()){
			if(n < smin.peek()){
				smin.push(n);
			}else{
				smin.push(smin.peek());
			}	
		}else{
			smin.push(n);
		}
	}
	
	public int pop(){
			smin.pop();
			return s.pop();
	}
	
	public int min(){
		return smin.peek();
	}
	
	public boolean empty(){
		return s.empty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		int[] a = {1, 2, 2, 8, 4, 3, 1, 2};
		for(int d : a){
			ms.push(d);
		}
		while( !ms.empty() ){
			System.out.println(ms.min());
			ms.pop();
			//System.out.println(ms.pop());
		}
	}

}
