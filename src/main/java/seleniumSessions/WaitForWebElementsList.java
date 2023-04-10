package seleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebElementsList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://www.freshworks.com/");

		By footer = By.xpath("//div[contains(@class, 'hFnGrz')]//a");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		///System.out.println(footerList.size());
		
		int footerCount = waitForElementsVisible(footer, 10).size();
		System.out.println(footerCount);
		
		int footerCountByPresence = waitForElementsPresence(footer, 10).size();
		System.out.println(footerCountByPresence);
		
		

	}
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 */

	public static List<WebElement> waitForElementsVisible(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		 return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * 
	 */
	
	public static List<WebElement> waitForElementsPresence(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		 return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}


}
