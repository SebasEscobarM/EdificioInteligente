package model;

public class Elevator {
	
	private int actualFloor;
	private Stack<String> upStack;
	private Stack<String> downStack;
	private boolean goUp;
	
	public Elevator(int n) {
		actualFloor=1;
		upStack=new Stack<>();
		downStack=new Stack<>();
		goUp=true;
	}
	
	
}
