package model;

import java.lang.reflect.Array;

public class Tower {
	
	private HashTable<Integer, Object> floors;
	private Elevator elv;
	private Object[] qus;
	
	public Tower(int flrs, int off) {
		//Definir como recibe hashTable el tipo generico E
		floors=new HashTable<>(flrs);
		//Anadir todas las oficinas
		elv=new Elevator(flrs*off);
		
		qus=Array.newInstance(Object.class, flrs);
		 
		
	}
	
}
