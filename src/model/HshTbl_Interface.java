package model;

public interface HshTbl_Interface<T,E> {
	
	public void add(E toAdd, int i);
	public E get(int i);
	public int size();
	public String toString(String s);
	public void setNodeVal(Object o);
}
