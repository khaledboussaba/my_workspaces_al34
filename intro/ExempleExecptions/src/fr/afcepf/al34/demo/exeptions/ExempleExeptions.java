package fr.afcepf.al34.demo.exeptions;

import java.io.File;
import java.io.IOException;

public class ExempleExeptions {

	public static void main(String[] args) {
		
		System.out.println("Début");
		
		try {
			plop();			
		} catch (NullPointerException | ArithmeticException | IOException e) {
			System.out.println("OUPS : " + e.getMessage());
			System.out.println("--------Stack trace--------");
			e.printStackTrace(System.out);
			System.out.println("--------Stack trace--------");
		}catch (Exception e) {
			System.out.println("OUPS : " + e.getMessage());
			System.out.println("--------Stack trace--------");
			e.printStackTrace(System.out);
			System.out.println("--------Stack trace--------");
		}
		
		System.out.println("Fin");
	}
	
	public static void plop() throws IOException {
		plip(0, null);
	}
	
	public static int plip(int x, Voiture v) throws IOException {
		v.accelerer(2);
		int result = 42 / x;
		File f = File.createTempFile("", "");
		return result;
	}

}
