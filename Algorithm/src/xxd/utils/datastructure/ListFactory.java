package xxd.utils.datastructure;

public class ListFactory {
	public static LNode<Character> createLinkedList(String s){
		if(s == null) return null;
		char[] charArray = s.toCharArray();
		LNode<Character> t, pre;
		LNode<Character> head = new LNode<Character>(charArray[0], null);
		pre = head;
		for(int i = 1; i < charArray.length; i++){
			t = new LNode<Character>(charArray[i], null);
			pre.setNext(t);
			pre = t;
		}
		
		return head;
	}
	
	public static LNode<Integer> createLinkedList(int[] a){
		if(a == null) return null;
		//char[] charArray = s.toCharArray();
		LNode<Integer> t, pre;
		LNode<Integer> head = new LNode<Integer>(a[0], null);
		pre = head;
		for(int i = 1; i < a.length; i++){
			t = new LNode<Integer>(a[i], null);
			pre.setNext(t);
			pre = t;
		}
		
		return head;
	}
	
}
