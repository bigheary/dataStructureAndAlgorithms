package swordoffer;

import java.util.Stack;

public class StackSequenceJudging {
	
	public boolean isLegal(int[] pushseq, int[] popseq){
		if(pushseq.length != popseq.length){
			return false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, j = 0;
		while(j < pushseq.length){
			
			if(stack.empty()){
				while(i < pushseq.length && pushseq[i] != popseq[j]){
					stack.push(pushseq[i++]);
				}
				if(i == pushseq.length)
					break;
				stack.push(pushseq[i]);	
				i++;
			}
			if(stack.peek() != popseq[j]){
				while(i < pushseq.length && pushseq[i] != popseq[j]){
					stack.push(pushseq[i++]);
				}
				if(i == pushseq.length)
					break;
				stack.push(pushseq[i]);
				i++;
			}else{
				stack.pop();
				j++;
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {4, 5, 3, 2, 1};
		int[] c = {4, 3, 5, 1, 2};
		StackSequenceJudging ssj = new StackSequenceJudging();
		System.out.println(ssj.isLegal(a, b));
	}

}
