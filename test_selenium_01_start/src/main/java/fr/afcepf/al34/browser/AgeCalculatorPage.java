package fr.afcepf.al34.browser;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgeCalculatorPage {

	private WebElement dayOfBith = null;
	private WebElement monthOfBirth = null;
	private WebElement yearOfBirth = null;
	private WebElement age = null;
	private WebElement zodiacSigne = null;
	private WebElement calculate = null;

	private WebDriver driver;
		Path sampleFile = Paths.get("pages2/exercise_6_1.html");
		
	private String url = sampleFile.toUri().toString();

	public AgeCalculatorPage(WebDriver webDriver) {
		driver = webDriver;
	}
	
	public void open() {
		this.driver.get(url);
	}
	
	public void close() {
		this.driver.quit();
	}
	
	public void calculate(String day, String month, String year) {
		getDayOfBith().sendKeys(day);
		getMonthOfBirth().sendKeys(month);
		getYearOfBirth().sendKeys(year);
		getCalculate().click();
	}

	public String getAge() {
		age = driver.findElement(By.id("age"));
		return age.getText();
	}
	
	public String getZodiacSigne() {
		zodiacSigne = driver.findElement(By.id("zodiacSign"));
		return zodiacSigne.getText();
	}

	public WebElement getDayOfBith() {
		dayOfBith = driver.findElement(By.id("dayOfBirth"));
		return dayOfBith;
	}

	public WebElement getMonthOfBirth() {
		monthOfBirth = driver.findElement(By.id("monthOfBirth"));
		return monthOfBirth;
	}

	public WebElement getYearOfBirth() {
		yearOfBirth = driver.findElement(By.id("yearOfBirth"));
		return yearOfBirth;
	}


	public WebElement getCalculate() {
		calculate = driver.findElement(By.id("calculate"));
		return calculate;
	}

	public void setDayOfBith(WebElement dayOfBith) {
		this.dayOfBith = dayOfBith;
	}

	public void setMonthOfBirth(WebElement monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public void setYearOfBirth(WebElement yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public void setAge(WebElement age) {
		this.age = age;
	}

	public void setZodiacSigne(WebElement zodiacSigne) {
		this.zodiacSigne = zodiacSigne;
	}

	public void setCalculate(WebElement calculate) {
		this.calculate = calculate;
	}



	
	
	
}
