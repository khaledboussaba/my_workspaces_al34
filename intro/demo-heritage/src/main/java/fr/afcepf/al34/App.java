package fr.afcepf.al34;

public class App {

	public static void main(String[] args) {

		Vehicle v;
		
		//v = new Vehicle(); pas possible vu que la classe Vehicle est abstract
		
		v = new Car();
		v.moveForward();
		System.out.println(v.getSpeed());
		System.out.println(v.isTerrestrial());
		System.out.println(v.toString());
		
		v = new Baot();
		v.moveForward();
		System.out.println(v.getSpeed());
		System.out.println(v.isTerrestrial());
		
		
		IFlyable f = new Plane();
		f.fly();
		
		System.out.println(f);
		
		f = new Bird();
		f.fly();
		
//		Bird b1 = new Bird("titi");
//		Bird b2 = new Bird("titi");
//		System.out.println(b1.equals(b2));
//		System.out.println(b1.name.equals(b2.name));
//		System.out.println(b1 == b2);
//		System.out.println(b1.name == b2.name);
		
	}

}
