package fr.afcepf.al34;

public class Baot extends Vehicle {
	
	public int draft;
	
	public void sink() {
		System.out.println("blupblupblupblup ......");
	}

	@Override
	public void moveForward() {
		super.moveForward();
		draft--;
	}

	@Override
	public boolean isTerrestrial() {
		return false;
	}
	
}