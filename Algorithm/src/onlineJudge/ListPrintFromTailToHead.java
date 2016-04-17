package onlineJudge;

import java.util.Stack;

import xxd.utils.datastructure.*;

//从尾到头打印链表
public class ListPrintFromTailToHead {
	
	public static <T> void printFromTailToHead(LNode<T> head){
		Stack<LNode<T>> nodes = new Stack<>();
		LNode<T> pnode = head;
		while(pnode != null){
			nodes.push(pnode);
			pnode = pnode.getNext();
		}
		
		while (!nodes.empty()) {
			System.out.println(nodes.pop().getData());
		}
	}
	
	public static <T> void printFromTailToHeadRecursive(LNode<T> head){
		/*if (head.getNext() == null) {
			System.out.println(head.getData());
			return;
		}*/
		
		if(head != null){
			if(head.getNext() != null)
				printFromTailToHeadRecursive(head.getNext());
			System.out.println(head.getData());	
		}
	}
	
	public static void main(String[] args){
		LNode<Character> head = ListFactory.createLinkedList("ABCDEFG");
		//printFromTailToHead(head);
		printFromTailToHeadRecursive(head);
	}
}
