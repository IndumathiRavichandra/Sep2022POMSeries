package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForTitleUrl {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		driver.findElement(By.linkText("Continue")).click();

		// title
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Register"));
//		System.out.println(driver.getTitle());

		// URL
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.urlContains("register"));
//		System.out.println(driver.getCurrentUrl());

		//Alert
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.alertIsPresent("register"));
//		System.out.println(driver.getCurrentUrl());
		
		
		
		String containsTitle = waitForTitleContains("Register", 10);
		System.out.println(containsTitle);

		String actualTitleIS = waitForTitleIs("Register Account", 10);
		System.out.println(actualTitleIS);

		String actualUrl = waitForurlContains("register", 10);
		System.out.println(actualUrl);
		
		String actualUrlToBe = waitForurlIs("https://naveenautomationlabs.com/opencart/index.php?route=account/register", 10);
		System.out.println(actualUrlToBe);
		
		
	}

	public static String waitForTitleContains(String titleFractionValue, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFractionValue))) {

			return driver.getTitle();
		}

		else {

			System.out.println("not visible");
			return null;
		}

	}

	public static String waitForTitleIs(String titleValue, int timeOut) {// Exact title

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(titleValue))) {

			return driver.getTitle();
		}

		else {

			System.out.println("not visible");
			return null;
		}

	}

	public static String waitForurlContains(String urlValue, int timeOut) {// Exact title

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlValue))) {

			return driver.getCurrentUrl();
		}

		else {

			System.out.println("incorrect url");
			return null;
		}

	}
	
	public static String waitForurlIs(String urlValue, int timeOut) {// Exact title

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlValue))) {

			return driver.getCurrentUrl();
		}

		else {

			System.out.println("incorrect url");
			return null;
		}

	}
	
	

}
