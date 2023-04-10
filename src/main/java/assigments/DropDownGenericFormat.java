package assigments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownGenericFormat {

	static WebDriver driver;

	public static void doSelectDropdownByValue(By locator, String value) {

		Select select = new Select(getElement(locator));

		List<WebElement> countryList = select.getOptions();
		System.out.println(countryList.size());
		
		int count = 1;
		
		for (WebElement e : countryList) {

			String text = e.getText();
			System.out.println(count + "-" +e.getText());
			if (text.equals(value)) {
				e.click();
				
			}
			count++;
		} 

	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(
				"https://www.orangehrm.com/orangehrm-30-day-trial/?gclid=Cj0KCQjw8e-gBhD0ARIsAJiDsaWZ6A-ll5Tq7f0obAroM0CZUlCx2wIMpFwwR7jMXlVE9KxF5pvm4EUaAmPwEALw_wcB");
		driver.manage().window().fullscreen();

		By country = By.xpath("//select[@id=\"Form_getForm_Country\"]");
		doSelectDropdownByValue(country, "India");
	}

}
