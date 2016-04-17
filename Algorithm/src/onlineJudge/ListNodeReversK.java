package onlineJudge;
import xxd.utils.datastructure.*;
public class ListNodeReversK {
	
	public static <T> LNode<T> findKthtoTail(LNode<T> head, int k ){
		if (head == null || k <= 0) {
			System.out.println("input List error or k error");
			return null;
		}
		
	    LNode<T> pAhead = head;
	    for(int i = 0; i < k - 1; i++){
	    	pAhead = pAhead.getNext();
	    	if (pAhead == null) {
	    		System.out.println("to long k");
				return null;
			}
	    }
	    LNode<T> pBehind = head;
	    while(pAhead.getNext() != null){
	    	pAhead = pAhead.getNext();
	    	pBehind = pBehind.getNext();
	    }
	    return pBehind;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNode<Character> head = ListFactory.createLinkedList("ABCDEF");
		LNode<Character> kthNode = findKthtoTail(head,7);
		//System.out.println(kthNode.getData());
	}

}
