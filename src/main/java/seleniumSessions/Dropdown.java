package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(
				"https://www.orangehrm.com/orangehrm-30-day-trial/?gclid=Cj0KCQjw8e-gBhD0ARIsAJiDsaWZ6A-ll5Tq7f0obAroM0CZUlCx2wIMpFwwR7jMXlVE9KxF5pvm4EUaAmPwEALw_wcB");
		
		driver.manage().window().setSize(new Dimension(500,400));

//			WebElement countryList = driver.findElement(By.id("Form_getForm_Country"));
//			
//			Select select = new Select(countryList);
//			//select.selectByIndex(5);
//			//select.selectByValue("Australia");
//			sCountry.selectByVisibleText("Australia");

		By countryList = By.id("Form_getForm_Country");
		// doSelectDropDownByIndex(countryList, 6);
		// doSelectDropDownByValue(countryList, "Australia");
		doSelectDropDownByVisibleText(countryList, "Congo");

	}

	public static void doSelectDropDownByIndex(By locator, int Index) {

		Select select = new Select(getElement(locator));
		select.selectByIndex(Index);

	}

	public static void doSelectDropDownByValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public static void doSelectDropDownByVisibleText(By locator, String text) {

		Select select = new Select(getElement(locator));
		select.selectByValue(text);

	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

}
