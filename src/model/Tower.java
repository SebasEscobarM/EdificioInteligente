package model;

public class Tower {
	
	private String twrId;
	private int flrs;
	private int off;
	private HashTable<Integer, Object> floors;
	private Elevator elv;
	private Object[] qus;
	
	public Tower(String twrId, int flrs, int off) {
		this.twrId=twrId;
		this.flrs=flrs;
		this.off=off;
		floors=new HashTable<>(flrs);
		elv=new Elevator(flrs*off);
		qus=new Object[flrs];
		int offNum=1;
		for(int i=flrs-1;i>=0;i--) {
			for(int j=0;j<off;j++) {
				PairNode<Integer, Object> nd=new PairNode<>(offNum,null);
				floors.add((Object)nd, (Integer)i);
				offNum++;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void order() {
		for(int i=0;i<flrs;i++) {
			if(elv.isGoUp()) {
				if(elv.getUpStack().size()!=0) {
					while(elv.getUpStack().top()!=null && elv.getUpStack().top().getDstnyFlr()==(i+1)) {
						floors.setNodeVal(elv.getUpStack().pop());;
					}
				}
			}
			
			Queue<Person> qu=(Queue<Person>)qus[i];
			if(qu!=null) {
				while(qu.head()!=null && qu.head().getDirect()>0) {
					elv.getUpStack().add(qu.poll());
				}
				while(qu.head()!=null && qu.head().getDirect()==0) {
					floors.setNodeVal(qu.poll());
				}
				while(qu.head()!=null && qu.head().getDirect()<0) {
					elv.getDownStack().add(qu.poll());
				}
			}
		}
		
		elv.setGoUp(false);
		
		for(int i=flrs-1;i>=0;i--) {
			if(!(elv.isGoUp())) {
				if(elv.getDownStack().size()!=0) {
					while(elv.getDownStack().size()!=0 && elv.getDownStack().top().getDstnyFlr()==(i+1)) {
						floors.setNodeVal(elv.getDownStack().pop());;
					}
				}
			}
		}
		
		while(!(elv.getUpStack().size()==0 && elv.getDownStack().size()==0)) {
			
			elv.setGoUp(true);
			
			for(int i=0;i<flrs;i++) {
				if(elv.isGoUp()) {
					if(elv.getUpStack().size()!=0) {
						while(elv.getUpStack().size()!=0 && elv.getUpStack().top().getDstnyFlr()==(i+1)) {
							floors.setNodeVal(elv.getUpStack().pop());;
						}
					}
				}
			}
			
			elv.setGoUp(false);
			
			for(int i=flrs-1;i>=0;i--) {
				if(!(elv.isGoUp())) {
					if(elv.getDownStack().size()!=0 && elv.getDownStack().size()!=0) {
						while(elv.getDownStack().top().getDstnyFlr()==(i+1)) {
							floors.setNodeVal(elv.getDownStack().pop());;
						}
					}
				}
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void addPPl(Person nwPerson) {
		if(qus[nwPerson.getIniFloor()-1]==null) {	
			Queue<Person> prsn=new Queue<>();
			qus[nwPerson.getIniFloor()-1]=(Object) prsn;
		}
		Queue<Person> flr=(Queue<Person>) qus[nwPerson.getIniFloor()-1];
		flr.add(nwPerson);
	}
	
	public String toString() {
		String msg="";
		
		msg+="Movimientos edificio "+ twrId+"\n\n";
		msg+=floors.toString(twrId)+"\n";
		return msg;
	}

	public String getTwrId() {
		return twrId;
	}

	public void setTwrId(String twrId) {
		this.twrId = twrId;
	}

	public int getFlrs() {
		return flrs;
	}

	public void setFlrs(int flrs) {
		this.flrs = flrs;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}

	public HashTable<Integer, Object> getFloors() {
		return floors;
	}

	public void setFloors(HashTable<Integer, Object> floors) {
		this.floors = floors;
	}

	public Elevator getElv() {
		return elv;
	}

	public void setElv(Elevator elv) {
		this.elv = elv;
	}

	public Object[] getQus() {
		return qus;
	}

	public void setQus(Object[] qus) {
		this.qus = qus;
	}
}
