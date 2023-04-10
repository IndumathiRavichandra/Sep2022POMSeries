package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExceptionWithFEandFEs {

	public static void main(String[] args) {
		
		
		//NoSuchElementException
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
		//driver.findElement(By.id("input-email111")).sendKeys("slfskf");
		List<WebElement> totLinks =  driver.findElements(By.xpath("//div[@@@@class=\"list-group11\"]/a"));
		System.out.println(totLinks.size());
		
		for(WebElement e: totLinks) {
			
			System.out.println(e.getText());
			
			//(By.xpath("//div[@class=\"list-group11\"]/a"));---- RETURNS 0 FOR FE's
			//(By.xpath("//div[@@@@class=\"list-group11\"]/a"));---- InvalidSelectorException 
			
		}
		

	}

} 
