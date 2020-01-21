package fr.afcepf.al34.browser;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium. By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium. chrome.ChromeDriver;

public class Overview_Script2 {

	public static void main(String[] args) throws InterruptedException {

		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		avoidingStaleElementReferenceException();
	} 

	private static void avoidingStaleElementReferenceException() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		try {

			Path sampletile = Paths.get("pages2/activity-1.html");
			driver.get(sampletile.toUri().toString());

			WebElement email = driver.findElement(By.id("inputEmail"));
			WebElement spanish = driver.findElement(By.id("spanish"));
			spanish.click();

			int tries = 0;
			while (tries < 2) {
				try {

					email.sendKeys("email@gmail.com");

					Thread.sleep(2000);

					if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
						System.out.println("=> 'email@gmail.com' tapé.");
					} else {
						System.out.println( "Wrong script.");
					}
					break;
				} catch (StaleElementReferenceException e) {
					email = driver.findElement(By.id("inputEmail"));
				}
				tries++;
			}
		} finally {
			driver.quit();
		}
	}
}
