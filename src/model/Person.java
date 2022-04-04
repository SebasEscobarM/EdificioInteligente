package model;

public class Person implements Comparable<Person>{
	
	private String name;
	private int  iniFloor;
	private int dstnyOff;
	private int direct;
	private int dstnyFlr;
	
	public Person(String name, int iniFloor, int dstnyOff, int direct, int dstnyFlr) {
		this.name=name;
		this.iniFloor=iniFloor;
		this.dstnyOff=dstnyOff;
		this.direct=direct;
		this.dstnyFlr=dstnyFlr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIniFloor() {
		return iniFloor;
	}

	public void setIniFloor(int iniFloor) {
		this.iniFloor = iniFloor;
	}

	public int getDstnyOff() {
		return dstnyOff;
	}

	public void setDstnyOff(int dstnyOff) {
		this.dstnyOff = dstnyOff;
	}
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getDstnyFlr() {
		return dstnyFlr;
	}

	public void setDstnyFlr(int dstnyFlr) {
		this.dstnyFlr = dstnyFlr;
	}

	@Override
	public int compareTo(Person o) {
		Person A=this;
		Person B=(Person) o;
		int ans=A.iniFloor-B.iniFloor;
		return ans;
	}
	
}