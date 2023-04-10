package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://classic.freecrm.com/index.html");

		By forgotPwd = By.linkText("Forgot Password?");

//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class)
//				.withMessage("Element Not Found");
//
//		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd));
	
		
		WebElement ele = waitForElementToBeVisibleWithFluentWait(forgotPwd, 10,2);
		ele.click();
		
	}
	
	public static WebElement waitForElementToBeVisibleWithFluentWait(By locator,int timeOut, int  intervalTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime)).ignoring(ElementNotInteractableException.class)
				.withMessage("Element Not Found");

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

}
