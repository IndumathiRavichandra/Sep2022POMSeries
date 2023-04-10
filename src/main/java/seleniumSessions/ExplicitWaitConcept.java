package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email = By.id("input-email");
		By pswd = By.id("input-password");
		By logBtn = By.xpath("//input[@value='Login']");

		//waitForElementPresence(email, 10).sendKeys("asdasfjnsd@mail.com");// ----------- since DOM element condition
		waitForElementVisible(email, 10).sendKeys("asdasfjnsd@mail.com");			// better compared to element presence													// satisfy--not req for the rest
		getElement(pswd).sendKeys("sadfasdf");
		getElement(logBtn).click();
	}

	/***
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 */
	
	public static WebElement waitForElementPresence(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/************************************************************************************************************************************************
	 * An expectation for checking that an element, known to be present on the DOM of a page, is visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 */
	
	public static WebElement waitForElementVisible(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
	

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

}
