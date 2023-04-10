package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		Thread.sleep(4000);

		By emailLocator = By.id("input-email");
		By pswdLocator = By.id("input-password");
		By loginLocator = By.xpath("//input[@type=\"submit\"]");

//		Actions act = new Actions(driver);
//
//		act.sendKeys(driver.findElement(emailLocator), "r.gmail.com").build().perform();
//		act.sendKeys(driver.findElement(pswdLocator), "asff").build().perform();
//		act.click(driver.findElement(loginLocaor)).build().perform();

		doActionSendKeys(emailLocator,"rasda.gmail.com");
		doActionSendKeys(pswdLocator,"aaaaa");
		doActionClick(loginLocator);
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static void doActionSendKeys(By locator, String value) {

		Actions act = new Actions(driver);

		act.sendKeys(getElement(locator), value).build().perform();
	}
	
	public static void doActionClick(By locator) {
		
		Actions act = new Actions(driver);

		act.click(getElement(locator)).build().perform();
	}

}
