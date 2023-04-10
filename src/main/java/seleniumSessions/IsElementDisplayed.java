package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IsElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/");

		By searchLocator = By.name("search");

		By logoLocator = By.xpath("//img[@title='naveenopencart']");

		doIsDisplayed(searchLocator);
		doIsDisplayed(logoLocator);

		if (IsSingleElementexists(searchLocator)) {

			System.out.println("element displayed");
		}
		if (IsSingleElementexists(logoLocator)) {

			System.out.println("logo element displayed");
		}

		

		if (IsTwoElementexists(searchLocator)) {

			System.out.println("Two element displayed");
		}
		if (IsTwoElementexists(logoLocator)) {

			System.out.println("Two logo element displayed");
		}

		
		
		
		IsMultipleElementexists(searchLocator, 1);
		
		
//		if (doIsDisplayed(searchLocator)) {
//
//			System.out.println("Pass");
//		}
//
//		if (doIsDisplayed(searchLocator)) {
//
//			System.out.println("Pass");
//		}
//
//		else {
//
//			System.out.println("Fail");
//		}

		// interview question ---- with Is Displayed to find.
//
//		int Count = driver.findElements(By.name("search")).size();
//		System.out.println(Count);
//		if (Count == 1) {
//
//			System.out.println("Count element displayed");
//
//		}
//
//		else {
//
//			System.out.println("fail");
//		}

//		boolean flag;
//		
//		if (flag=true) {
//			System.out.println("Element displayed");
//		}
//		
//		else {
//			
//			System.out.println("Element Not displayed");
//			
//		}

	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();

	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public static boolean IsSingleElementexists(By locator) {

		int actualCount = getElements(locator).size();
		System.out.println("actualCount" + " " + actualCount);
		if (actualCount == 1) {
			return true;

		}
		return false;

	}
	
	
	public static boolean IsTwoElementexists(By locator) {

		int actualCount = getElements(locator).size();
		System.out.println("actualCount" + " " + actualCount);
		if (actualCount == 2) {
			return true;

		}
		return false;

	}
	
	public static boolean IsMultipleElementexists(By locator, int expectedElementCount) { // or use if (actualCount >1) {

		int actualCount = getElements(locator).size();
		System.out.println("actualCount" + " " + actualCount);
		if (actualCount == expectedElementCount) {
			return true;

		}
		return false;

	}
}