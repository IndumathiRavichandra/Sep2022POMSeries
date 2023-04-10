package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FEsGenericMethods {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://www.freshworks.com/");

		By footerLinks = By.xpath("//div[contains(@class, 'hFnGrz')]//a");

		List<String> actualElementTextList = getElementsTextList(footerLinks);
		System.out.println(actualElementTextList);

		if (actualElementTextList.contains("Investors")) {

			System.out.println("PASS");
		} else {
			System.out.println("no");
		}
		
		int countFooter = totalElementsCount(footerLinks);
		System.out.println(countFooter);
		if(countFooter == 26) {
			
			System.out.println("Count correct");
			
		}
		
		else {
			
			System.out.println("Count incorrect");
		}
	}

	public static List<String> getElementsTextList(By locator) {

		List<WebElement> footerList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : footerList) {

			String text = e.getText();
			eleTextList.add(text);
			
			
		}

		return eleTextList;

	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public static int totalElementsCount(By locator) {

		return getElementsTextList(locator).size();

	}
	
	
	
	
}
