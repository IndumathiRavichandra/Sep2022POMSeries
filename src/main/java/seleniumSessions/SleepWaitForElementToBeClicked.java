package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SleepWaitForElementToBeClicked {

	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://classic.freecrm.com/index.html");

		By forgotPwd = By.linkText("Forgot Password?");

		//polling method Sleep
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(1000));
		wait.until(ExpectedConditions.elementToBeClickable(forgotPwd)).click();
		wait.ignoring(NoSuchElementException.class);

		ClickElementWhenReady(forgotPwd, 10, 1000);
		
		
		
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 */
	public static void ClickElementWhenReady(By locator, int timeOut, long intervalTime) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofMillis(intervalTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();;
		wait.ignoring(NoSuchElementException.class);
		
	}

}
