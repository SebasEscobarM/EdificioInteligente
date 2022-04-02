package model;

public class Stack<E> {
	
	private SimpleNode<E> topList;
	private int size;
	
	public Stack(){
		topList=null;
		size=0;
	}
	
	public void add(E nwEl) {
		SimpleNode<E> nwNd=new SimpleNode<>(nwEl);
		if(topList!=null) {
			nwNd.setNext(topList);	
		}
		topList=nwNd;
		size++;
	}
	
	public E top() {
		return topList.getItem();
	}
	
	public E pop() {
		SimpleNode<E> top=topList;
		topList=top.getNext();
		size--;
		return top.getItem();
	}
	
	public int size() {
		return size;
	}
	
}
