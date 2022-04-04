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
		//Reescribir next
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
					added=true;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString(String s) {
		String msg="";
		String listOf="Estado final de las oficinas en el edificio "+s+"\n[";
		for(int i=tbl.length-1;i>=0;i--) {
			PairNode<Integer,Object> nd=(PairNode<Integer,Object>) tbl[i];
			while(nd.getNext()!=null) {
				if(nd.getItem()!=null) {
					Person pr=(Person) nd.getItem();
					msg+=pr.getName()+" se mueve a la oficina: "+nd.getKey()+"\n";
					listOf+=pr.getName()+", ";
				}else {
					listOf+="Vacia, ";
				}
				nd=nd.getNext();
			}
			if(nd.getItem()!=null) {
				Person pr=(Person) nd.getItem();
				msg+=pr.getName()+" se mueve a la oficina: "+nd.getKey()+"\n";
				listOf+=pr.getName()+", ";
			}else {
				listOf+="Vacia, ";
			}
		}
		return msg+"\n\n"+listOf.substring(0, listOf.length()-2)+"]";
	}
	@Override
	public E get(int i) {
		return tbl[i];
	}

	@Override
	public int size() {
		return tbl.length;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void setNodeVal(Object o) {
		Person prs=(Person) o;
		boolean added=false;
		PairNode<Integer,Person> nd=(PairNode<Integer,Person>) tbl[prs.getDstnyFlr()-1];
		while(!added) {
			if(nd!=null && nd.getKey()==prs.getDstnyOff()) {
				nd.setItem(prs);
				added=true;
			}else {
				nd=nd.getNext();
			}
		}
	}

	
	
}
