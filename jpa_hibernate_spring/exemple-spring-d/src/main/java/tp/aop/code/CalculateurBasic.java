package tp.aop.code;

import org.springframework.stereotype.Component;

@Component //cette classe sera vue comme un composant spring
public class CalculateurBasic implements Calculateur {

	
	public double addition(double a, double b) {
		return a+b;
	}

	
	public double multiplication(double a, double b) {
		return a*b;
	}

}
