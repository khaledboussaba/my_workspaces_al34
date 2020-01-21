package com.formation.script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.formation.AgeCalculatorPage;

public class AgeCalculatorScript {

	public static void main(String[] args) throws Exception {
		String chromeDriverPath = "C:\\Users\\formation\\Desktop\\Notes_Perso\\13-QL\\selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		checkAgeCalculator();
	}

	private static void checkAgeCalculator() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		AgeCalculatorPage ageCalculatorPage = new AgeCalculatorPage(driver);
		ageCalculatorPage.open();
		
		ageCalculatorPage.calculate("11", "February", "1980");
		
		if (ageCalculatorPage.getAge().equals("40")) {
			System.out.println("Age was calculated correctly !");
		} else {
			System.out.println("There was an error in the age calculation !");
		}
		
		if (ageCalculatorPage.getZodiacSign().equals("Aquarius")) {
			System.out.println("Zodiac sign was calculated coorectly !");
		} else {
			System.out.println("There was an error in the zodiac sign calculation !");
		}
		ageCalculatorPage.close();
	}
	
}
