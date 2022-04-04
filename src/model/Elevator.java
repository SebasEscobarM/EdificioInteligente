package model;

public class Elevator {
	
	private int actualFloor;
	private Stack<Person> upStack;
	private Stack<Person> downStack;
	private boolean goUp;

	
	public Elevator(int n) {
		actualFloor=1;
		upStack=new Stack<>();
		downStack=new Stack<>();
		goUp=true;
	}


	public int getActualFloor() {
		return actualFloor;
	}


	public void setActualFloor(int actualFloor) {
		this.actualFloor = actualFloor;
	}


	public Stack<Person> getUpStack() {
		return upStack;
	}

	public Stack<Person> getDownStack() {
		return downStack;
	}

	public boolean isGoUp() {
		return goUp;
	}


	public void setGoUp(boolean goUp) {
		this.goUp = goUp;
	}
	
	
	
}
