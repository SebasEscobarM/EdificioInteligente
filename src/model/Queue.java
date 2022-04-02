package model;

public class Queue<E> {

	private SimpleNode<E> tail;
	private SimpleNode<E> head;
	private int size;
	
	public Queue() {
		tail=null;
		head=null;
		size=0;
	}
	
	public void add(E nwEl) {
		SimpleNode<E> nwNd=new SimpleNode<>(nwEl);
		if(head==null && tail==null) {
			head=nwNd;
			tail=nwNd;
		}else {
			tail.setNext(nwNd);
			tail=nwNd;
		}
		size++;
	}
	
	public E head() {
		if(head!=null) {
			return head.getItem();	
		}else {
			return null;
		}
			
	}
	
	public E poll() {
		if(head!=null) {
			E itm=head.getItem();
			head=head.getNext();
			size--;
			return itm;	
		}else {
			return null;
		}
			
	}
	
	public int size() {
		return size;
	}
}
