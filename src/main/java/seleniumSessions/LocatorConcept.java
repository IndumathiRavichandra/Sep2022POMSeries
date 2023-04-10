package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().fullscreen();
		
		//driver.findElement(By.name("firstname")).sendKeys("Indu");
		
		
		By fName = By.name("firstname");
		By lName = By.xpath("//*[@id=\"input-lastname\"]");
		By subs = By .xpath("//*[@id=\"input-lastname\"]");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(fName, "Indu");
		eleUtil.doSendKeys(lName, "mathi R");

		eleUtil.doClick(subs);
		
	}

}
