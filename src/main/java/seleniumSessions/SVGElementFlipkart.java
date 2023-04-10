package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SVGElementFlipkart {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	
		driver.get("https://www.flipkart.com/");
		
		String xpath = "//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']";
		
		By searchIcon = By.xpath(xpath);
		
		driver.findElement(By.name("q")).sendKeys("macbook pro");
		
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(searchIcon)).build().perform();
		
		
				
		
	}

}
