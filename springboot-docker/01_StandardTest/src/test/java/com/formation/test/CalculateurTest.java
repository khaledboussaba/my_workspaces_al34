package com.formation.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.formation.Calculateur;

class CalculateurTest {
	
	Calculateur calculateur = new Calculateur();
	
	@Test
	void additioner() {
		double result = calculateur.addition(5, 6);
		assertEquals(result, 11);
	}
	
	@Test
	void soustraction() {
		double result = calculateur.soustraction(5, 6);
		assertEquals(result, -1);
	}


}
