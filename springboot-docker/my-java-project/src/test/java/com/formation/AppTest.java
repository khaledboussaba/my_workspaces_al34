package com.formation;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

	private final String INPUT = "12345";
	
	@Test
	public void testLength() {
		Assert.assertEquals(64, App.sha256(INPUT).length());
	}
	
	@Test
	public void testHex() {
		String expected = "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5";
		Assert.assertEquals(expected, App.sha256(INPUT));
	}


}
