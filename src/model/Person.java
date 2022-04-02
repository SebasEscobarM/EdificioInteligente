package model;

public class Person {
	
	private String name;
	private int  iniFloor;
	private int dstnyOff;
	
	public Person(String name, int iniFloor, int dstnyOff) {
		this.name=name;
		this.iniFloor=iniFloor;
		this.dstnyOff=dstnyOff;
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
	
	
}