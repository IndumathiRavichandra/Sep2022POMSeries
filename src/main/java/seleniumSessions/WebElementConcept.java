package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementConcept {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1st approach 
		//driver.findElement(By.id("input-email")).sendKeys("indu.gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("abc123");
		
		
		//2nd approach 
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		emailId.sendKeys("indu.gmail.com");
//		 
//		
//		WebElement pswd = driver.findElement(By.id("input-password"));
//		pswd.sendKeys("abc123");
		
		//******************************3rd - By locator approach
//		
//		By emailId = By.id("input-email");
//		WebElement email_ele = driver.findElement(emailId);
//		email_ele.sendKeys("indu.gmail.com");
//		
//		By pwd = By.id("input-password");
//		WebElement pswd_elem = driver.findElement(pwd);
//		pswd_elem.sendKeys("abc123");
//		
//		//*****************4th By locator + generic function
		
		
		
//		By emailId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		getElement(emailId).sendKeys("indu.gmail.com");
//		getElement(pwd).sendKeys("abc123");
//		
//	}
//		
//		public static WebElement getElement(By locator){
//			
//			return driver.findElement(locator);
//			
//				
//	}
		
		//*****************5th By locator + generic function+action methods
		
//		By emailId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		
//		doSendKeys(emailId, "indu.gmail.com");
//		doSendKeys(pwd, "abc123");
//		
//	}
//		
//		public static WebElement getElement(By locator){
//			
//			return driver.findElement(locator);
//			
//				
//	}
//		
//		public static void doSendKeys(By locator, String value) {
//			getElement(locator).sendKeys(value);
//			
//		}
		
		//6th By locator + generic function+action methods
		
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "indu.gmail.com");
		eleUtil.doSendKeys(pwd, "abc123");
//		
	}
}
