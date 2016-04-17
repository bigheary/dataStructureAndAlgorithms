package xxd.utils.datastructure;

public class LNode<T> {
	private T data;
	private LNode<T> next;
	
	public static <T> void printList(LNode<T> phead) {
		LNode t = phead;
		while(t != null){
			System.out.println(t.getData());
			t = t.getNext();
		}
	}
	
	public LNode(T data, LNode next){
		this.data = data;
		this.next = next;
	}
	
	public void setData(T data){
		this.data = data;
	}
	public T getData(){
		return data;
	}
	
	public void setNext(LNode next){
		this.next = next;
	}
	public LNode<T> getNext(){
		return next;
	}
}
