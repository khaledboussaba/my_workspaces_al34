package fr.afcepf.al34.browser;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Find_Element {

	public static void main(String[] args) {
		String chromeDriverPath ="C:\\Users\\formation\\Desktop\\env_selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		locatingElements();
	}

	
	private static void locatingElements() {
		WebDriver driver = new ChromeDriver();

		try {
			Path sampleFile = Paths.get("pages2/activity-2.html");
			driver.get(sampleFile.toUri().toString());
			
			WebElement lastName = driver.findElement(By.id("lastName"));
			if(lastName.isDisplayed()) {
				System.out.println("*** lastName is visible");
			} else {
				System.out.println( "Wrong script 1");
			}
			
			
			WebElement hobbies = driver.findElement(By.id("hobbies"));
			if(hobbies.isDisplayed()) {
				System.out.println("*** hobbies is visible");
			} else {
				System.out.println( "Wrong script 2");
			}
			
			
			WebElement firstName = driver.findElement(By.className("form-control"));
			if(firstName.isDisplayed()) {
				System.out.println("*** firstName is visible");
			} else {
				System.out.println( "Wrong script 3");
			}
			
			
			List<WebElement> div = driver.findElements(By.tagName("div"));
			if (div.size() > 0) {
				System.out.println("*** Il y a " + div.size() + " div dans cette page");
			} else {
				System.out.println( "Wrong script 4");
			}
			
			
			WebElement spanishLink = driver.findElement(By.linkText("Spanish"));
			String link = spanishLink.getAttribute("href");
			if(!"".equals(link)) {
				System.out.println("*** Lien trouvé");
			} else {
				System.out.println( "Wrong script 5");
			}
			
			
			Select dayOfBirth = new Select(driver.findElement(By.xpath("//select")));
			if (dayOfBirth.getOptions().size() > 0) {
				System.out.println("*** Element 'select' trouvé");
			} else {
				System.out.println( "Wrong script 6");

			}
			
			
			WebElement firstNameWithCss = driver.findElement(By.cssSelector("#firstName"));
			if(firstNameWithCss.isDisplayed()) {
				System.out.println("*** firstName with CSS is visible");
			} else {
				System.out.println( "Wrong script 7");
			}
			
		} finally {
			driver.quit();
		}
	}
}
