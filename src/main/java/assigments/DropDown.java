package assigments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDown {
	
	static WebDriver driver;


	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(
				"https://www.orangehrm.com/orangehrm-30-day-trial/?gclid=Cj0KCQjw8e-gBhD0ARIsAJiDsaWZ6A-ll5Tq7f0obAroM0CZUlCx2wIMpFwwR7jMXlVE9KxF5pvm4EUaAmPwEALw_wcB");

		
		List<WebElement> countryList = driver.findElements(By.xpath("//select[@id=\"Form_getForm_Country\"]/option"));
		
		System.out.println(countryList.size());
		
		for (WebElement e : countryList) {
			
			String text = e.getText();
			if(text.equals("India")) {
			e.click();
			System.out.println(text);
			break;
		}
		
			
		
		

	}

	}
}
