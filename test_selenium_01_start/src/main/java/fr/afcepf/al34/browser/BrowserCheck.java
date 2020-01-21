package fr.afcepf.al34.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCheck {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);

		try {
			driver.get("https://google.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			if(driver.getTitle().equalsIgnoreCase("Google")) {
				System.out.println("Le titre contient Google");
			} else {
				System.out.println("La page Google est introuvable");
			}
			driver.navigate().to("https://bing.com");
			if(driver.getTitle().equalsIgnoreCase("Bing")) {
				System.out.println("Le titre contient Bing");
			} else {
				System.out.println("La page Bing est introuvable");
			}
			driver.navigate().back();
			if(driver.getTitle().equalsIgnoreCase("Google")) {
				System.out.println("Le titre contient Google");
			} else {
				System.out.println("La page Google est introuvable");
			}
		} finally {
			driver.quit();			
		}
	}

}
