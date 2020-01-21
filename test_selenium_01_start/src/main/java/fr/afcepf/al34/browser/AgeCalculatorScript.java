package fr.afcepf.al34.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgeCalculatorScript {

	public static void main(String[] args) throws Exception{
		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		checkAgeCalculator();
	}
	
	private static void checkAgeCalculator() throws Exception {
		WebDriver driver = new ChromeDriver();
		AgeCalculatorPage ageCalcPage = new AgeCalculatorPage(driver);
		ageCalcPage.open();
		
		ageCalcPage.calculate("11", "February", "1982");
		
		if(ageCalcPage.getAge().equals("36")) {
			System.out.println("*** Age correctement calculé");
		} else {
			System.out.println(" *** Age incorrectement calculé");
		}
		
		if(ageCalcPage.getZodiacSigne().equals("Aquarius")) {
			System.out.println("*** Signe correctement identifié");
		} else {
			System.out.println(" *** Signe incorrectement identifié");
		}
		ageCalcPage.close();
	}
}
