package model;

import java.lang.reflect.Array;

public class HashTable<T,E> implements HshTbl_Interface<T, E>{
	
	private E[] tbl;
	
	@SuppressWarnings("unchecked")
	public HashTable(int n) {
		tbl=(E[]) Array.newInstance(Object.class, n);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(E toAdd, int i) {
		//Reescribir add
		
		if(tbl[i]==null) {
			tbl[i]=toAdd;
		}else {
			boolean added=false;
			PairNode<T,E> nd=(PairNode<T,E>)tbl[i];
			while(!added) {
				if(nd.getNext()!=null) {
					nd=nd.getNext();
				}else {
					nd.setNext((PairNode<T,E>)toAdd);
				}
			}
		}
	}

	@Override
	public E get(int i) {
		return tbl[i];
	}

	@Override
	public int size() {
		return tbl.length;
	}

	
	
}
