package assigments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GSearch {

	static WebDriver driver;

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static void doClick(By locator, String value) {

		List<WebElement> suggListText = driver.findElements(locator);

		for (WebElement e : suggListText) {

			String text = e.getText();
			System.out.println(text);

			if (text.contains(value)) {
				e.click();
				break;
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("selenium");

		Thread.sleep(1000);

		By LinkList = By.xpath("//div[@class=\"wM6W7d\"]/span");
		doClick(LinkList, "selenium webdriver");

	}

}
