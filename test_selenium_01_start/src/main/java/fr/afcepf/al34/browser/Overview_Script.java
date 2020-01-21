package fr.afcepf.al34.browser;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium. By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium. chrome.ChromeDriver;

public class Overview_Script {



	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		gettingStaleELementReferenceException();

	}

	private static void gettingStaleELementReferenceException() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			Path sampleFile = Paths.get("pages2/activity-1.html");
			driver.get(sampleFile.toUri().toString());

			WebElement spanish = driver.findElement(By.id("spanish"));
			spanish.click();

			WebElement email = driver.findElement(By.id("inputEmail"));

			email.sendKeys("email@gmail.com") ;

			Thread. sleep(5000) ;

			if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
				System.out.println("=> 'email@gmail.com' tapé.");

			} else {

				System.out.println("Mauvais script.");

			}
		} finally {
			driver.quit();
		}

	}
}
