package assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Thread.sleep(5000);

		By fNameLocator = By.id("input-firstname");
		By lNameLocator = By.id("input-lastname");
		By emailLocator = By.id("input-email");
		By teleLocator = By.id("input-telephone");
		By pswdLocator = By.id("input-password");
		By pswdConfirmLocator = By.id("input-confirm");
		By checkboxLocator = By.xpath("//input[@type= 'checkbox']");
		By confirmLocator = By.xpath("//input[@value = 'Continue']");

		doSendKeys(fNameLocator, "dddddddddInddddddu");
		doSendKeys(lNameLocator, "Rdfasdg");
		doSendKeys(emailLocator, "inddsgsgu@gmail.com");
		doSendKeys(teleLocator, "101357878");
		doSendKeys(pswdLocator, "123abc");
		doSendKeys(pswdConfirmLocator, "123abc");
		
		

		doClick(checkboxLocator);
		doClick(confirmLocator);


	}

	public static WebElement goElement(By locator) {

		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {

		goElement(locator).sendKeys(value);

	}

	public static void doClick(By locator) {

		goElement(locator).click();

	}

}
