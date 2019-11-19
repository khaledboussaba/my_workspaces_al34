package fr.afcepf.al34;

public abstract class Vehicle {

	private String color;
	private int length;
	private int width;
	private int speed;


	public void start() {
		System.out.println("Start-up vehicle !!!");
	}

	public void moveForward() {
		speed += 2;
	}

	public int getSpeed() {
		return speed;
	}
	
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract boolean isTerrestrial();
	
	@Override
	public String toString() {
		return ", couleur : " + color + ", dimensions : " + width + " x " + length;
	}
	
}
