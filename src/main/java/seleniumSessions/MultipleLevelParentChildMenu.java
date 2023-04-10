package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MultipleLevelParentChildMenu {// Move to Element

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://www.bigbasket.com/");

		driver.manage().window().fullscreen();

		selectLevel4MenuItem("a", "categoryDD", "Beverages", "Tea", "Tea Bags");
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static void selectLevel4MenuItem(String htmltag, String level1Menu, String level2Menu, String level3Menu,
			String level4Menu) throws InterruptedException {

		By parentMenuLocator = By.xpath("//a[@qa='" + level1Menu + "']"); // a[@qa="categoryDD"]
		By childMenuLocator = By.xpath("(//" + htmltag + "[text()='" + level2Menu + "'])[2]"); //// a[text()='Beverages'])[2]
		By subchildMenuLocator = By.xpath("(// " + htmltag + "[text()='" + level3Menu + "'])[2]"); // (//a[text()='Tea'])[2]
		By grandSubChildMenuLocator = By.xpath("(//" + htmltag + "[text()='" + level4Menu + "'])[2]"); // (//a[text()='Tea
																										// Bags'])[2]

		WebElement categoryDDLocator = getElement(parentMenuLocator);
		Actions act = new Actions(driver);
		act.moveToElement(categoryDDLocator).build().perform();
		Thread.sleep(3000);

		WebElement BeveragesLocator = getElement(childMenuLocator);
		act.moveToElement(BeveragesLocator).build().perform();
		Thread.sleep(3000);

		WebElement TeaLocator = getElement(subchildMenuLocator);
		act.moveToElement(TeaLocator).build().perform();
		Thread.sleep(3000);

		WebElement TeaBagLocator = getElement(grandSubChildMenuLocator);
		act.moveToElement(TeaBagLocator).build().perform();
		Thread.sleep(3000);

		doClick(grandSubChildMenuLocator);

	}

	public static void doClick(By locator) {

		getElement(locator).click();

	}

}