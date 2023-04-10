package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowDomElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(4000);
		
		//driver.findElement(By.id("tea")).sendKeys("yes");		---shadow dom, so this wont work
		
		driver.switchTo().frame("pact");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
				
		WebElement tea = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector('#tea')");
				
		tea.sendKeys("Masala Tea");
				
				
	}

}
