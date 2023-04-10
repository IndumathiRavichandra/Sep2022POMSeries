package assigments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FooterAssignment {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://www.freshworks.com/");

		By footer = By.xpath("//div[contains(@class, \"sc-6293d692-0 eNMhGa\")]//a");

		getElementsTextList(footer);
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public static void getElementsTextList(By locator) {

		List<WebElement> footerList = driver.findElements(locator);
		for (WebElement e : footerList) {

			String text = e.getText();
			System.out.println(text);
		}

	}

}
