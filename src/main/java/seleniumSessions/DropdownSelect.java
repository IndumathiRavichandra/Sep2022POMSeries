package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {

	static WebDriver driver;

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	

	public static void doSelectDropDownValue(By locator, String value) {

		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {

				e.click();
				break;

			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(
				"https://www.orangehrm.com/orangehrm-30-day-trial/?gclid=Cj0KCQjw8e-gBhD0ARIsAJiDsaWZ6A-ll5Tq7f0obAroM0CZUlCx2wIMpFwwR7jMXlVE9KxF5pvm4EUaAmPwEALw_wcB");

		Thread.sleep(1000);
		By country = By.id("Form_getForm_Country");
		doSelectDropDownValue(country, "Canada");
//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
//		Select select = new Select(country);
//		
//		List<WebElement> countryList = select.getOptions();
//		System.out.println(countryList.size());
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if (text.equals("Canada")){
//				
//				e.click();
//				break;
//				
//			}
//			
//		}

	}

}
