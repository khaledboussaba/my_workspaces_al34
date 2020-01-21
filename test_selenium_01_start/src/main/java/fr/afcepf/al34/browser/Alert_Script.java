package fr.afcepf.al34.browser;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Script {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		alertCheck();
	} 

	private static void alertCheck() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		try {

			Path sampleFile = Paths.get("pages/alert.html");
			driver.get(sampleFile.toUri().toString());


			Alert simpleAlert = driver.switchTo().alert();
			System.out.println("Alert text contents: " + simpleAlert.getText());
			Thread.sleep(1000);
			if (simpleAlert.getText().equalsIgnoreCase("Simple alert.")) {
				System.out.println("Simple alert visible");
			}
			else {
				System.out.println("Sinple alert invisible");

			}
			simpleAlert.accept();


			Alert confirmAlert = driver.switchTo().alert();
			if (confirmAlert.getText().equalsIgnoreCase("Confirm alert.")) {
				System.out.println("Corfirmation alert visible");
			}
			else {
				System.out.println("Corfirmation alert invisible");
			}
			Thread.sleep(1000) ;
			confirmAlert.accept();


			Alert promptAlert =driver.switchTo().alert();
			Thread. sleep (1000);
			promptAlert.sendKeys("Java");
			Thread.sleep(1000);
			promptAlert.accept();
			Thread.sleep(1000);
			if (driver.getTitle().contains("Java")) {
				System.out.println("Title = Java");
			} else {
				System.out.println("Title != Java");
			}
			Thread.sleep(1000);
		} finally {
			driver.quit();

		}
	}
}

