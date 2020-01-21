package fr.afcepf.al34.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fenetre_Script {

public static void main(String[] args) {
	String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	activityLesson2AutomationScript();
	
}

private static void activityLesson2AutomationScript() {
	
	WebDriver driver = new ChromeDriver();
	try {
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.manage().window().setSize(new Dimension(300,500));
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(300,500));

	} catch (Exception e) {
	} finally {
		driver.quit();			
	}
}
}
