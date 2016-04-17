package onlineJudge;

import xxd.utils.datastructure.LNode;
import xxd.utils.datastructure.ListFactory;

public class ReverseLinkList {
	
	public static <T> LNode<T> reverseLinkList(LNode<T> head) {
		if(head == null)
			return null;
		LNode<T> pre, cur, post;
		pre = null;
		cur = head;
		post = head.getNext();
		while(post != null){
			cur.setNext(pre);
			pre = cur;
			cur = post;
			post = cur.getNext();
		}
		cur.setNext(pre);
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNode<Character> head = ListFactory.createLinkedList("AB");
		LNode.printList(head);
		
		LNode.printList(reverseLinkList(head));
	}

}
