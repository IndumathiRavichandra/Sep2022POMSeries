package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetAttributeConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");

		// ----------------------------------driver.findElement(By.id("nav-logo-sprites")).getAttribute("href");

//		String hrefValue = driver.findElement(By.id("nav-logo-sprites")).getAttribute("href");
//		System.out.println(hrefValue);

//		
//		WebElement ele = driver.findElement(By.id("nav-logo-sprites"));
//		String hrefValue = ele.getAttribute("href");
//		String label = ele.getAttribute("aria-label");
//		System.out.println(hrefValue);
//		System.out.println(label);
		
		
		By logo = By.id("nav-logo-sprites");
		
		
		String hrefValue = doGetAttributeValue(logo, "href");
		String label = doGetAttributeValue(logo, "aria-label");
		System.out.println(hrefValue);
		System.out.println(label);
		
	
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static String doGetAttributeValue(By locator, String attrbtName) {

		return getElement(locator).getAttribute(attrbtName);

	}

}
