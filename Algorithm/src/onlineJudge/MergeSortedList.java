package onlineJudge;

import xxd.utils.datastructure.*;

public class MergeSortedList {
	public static LNode<Integer> merge(LNode<Integer> pHead1, LNode<Integer> pHead2){
		if(pHead1 == null)
			return pHead2;
		if(pHead2 == null)
			return pHead1;
		
		LNode<Integer> mergeHead = null;
	    if (pHead1.getData() < pHead2.getData()) {
			mergeHead = pHead1;
			mergeHead.setNext(merge(pHead1.getNext(), pHead2));
	    }else {
			mergeHead = pHead2;
			mergeHead.setNext(merge(pHead1, pHead2.getNext()));
		}
	    
	    return mergeHead;
	}
	
	public static void main(String[] args){
		LNode<Integer> head1 = ListFactory.createLinkedList(new int[]{1, 3, 5, 7});
		LNode<Integer> head2 = ListFactory.createLinkedList(new int[]{2, 4, 6, 8});
		LNode<Integer> headmerge = merge(head1, head2);
		LNode.printList(headmerge);
	}
}
