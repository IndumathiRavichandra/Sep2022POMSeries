package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiSele_WebTablePaginationConcept { // single selection

	static WebDriver driver;

	public static void selectCountry(String country) { // ---------single selection

		driver.findElement(By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();

	}

	public static void selectMultipleCountry(String country) {// ---------multiple selection

		List<WebElement> checkboxList = driver.findElements(
				By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input[@type='checkbox']"));

		for (WebElement e : checkboxList) {

			e.click();

		}

	}

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);

		// multi selection
		while (true) {

			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {

				selectMultipleCountry("India");

			}

			WebElement next = driver.findElement(By.linkText("Next"));

			Thread.sleep(3000);

			if (next.getAttribute("class").contains("disabled")) {

				System.out.println("pagination over... country is not found");
				break;
			}

			next.click();

			Thread.sleep(3000);
		}

	}

}
