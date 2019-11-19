package fr.afcepf.al34;

public class Bird implements IFlyable {

	public String name;
		
	public Bird() {
	}
	
	public Bird(String name) {
		this.name = name;
	}

	public void fly() {
		System.out.println("I'm a bird and I fly !!!");
	}

}