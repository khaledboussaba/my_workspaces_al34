package fr.afcepf.al34;

public class Car extends Vehicle {
	
	private int engine;
	private int power;
	
	public void goFlat() {
		System.out.println("pffffffff");
	}
	
	@Override
	public void moveForward() {
		setSpeed(getSpeed() + 10);
	}

	@Override
	public boolean isTerrestrial() {
		return true;
	}
	
	@Override
	public String toString() {
		return "CAR : engine : " + engine + ", power : " + power + " " + super.toString();
	}

}