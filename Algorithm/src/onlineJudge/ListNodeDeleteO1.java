package onlineJudge;
import xxd.utils.datastructure.*;

public class ListNodeDeleteO1 {
	
	public static <T> void deleteNode(LNode<T> head, LNode<T> tobeDeleted){
		if (head == null || tobeDeleted == null) {
			return;
		}
		
		//只有一个节点
		if (head.getNext() == null && head == tobeDeleted) {
			head = null;
		}else if (tobeDeleted.getNext() != null) {//删除的非最后一点
			LNode<T> pnext = tobeDeleted.getNext();
			tobeDeleted.setData(pnext.getData());
			tobeDeleted.setNext(pnext.getNext());
			// delete pnext
		}else {
			
		}
		
	}
	
	public static void main(String[] args) {
		LNode<Character> head = ListFactory.createLinkedList("ABCDEF");
		LNode t;
		t = head;
		for(int i = 0; i < 3; i++)
			t = t.getNext();
		LNode.printList(head);
		deleteNode(head, null);
		LNode.printList(head);
	}
}
