package fr.logger;

public class BadLogger implements MyLogger {

	@Override
	public void log(String message) {
		System.out.println(">> Bad log >> " + message);
	}

}
