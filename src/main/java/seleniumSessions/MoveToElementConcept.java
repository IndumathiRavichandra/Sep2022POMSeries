package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {

	static WebDriver driver;

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static void selectSubMenu(String htmltag, String parentMenu, String childMenu) throws InterruptedException {

		By parentMenuLocator = By.xpath("//" + htmltag + "[text()='" + parentMenu + "']");

		By childMenuLocator = By.xpath("//" + htmltag + "[text()='" + childMenu + "']"); // " + --- + " ---- if div changes later

		WebElement parentMenuElement = getElement(parentMenuLocator);

		Actions act = new Actions(driver);

		act.moveToElement(parentMenuElement).build().perform();

		Thread.sleep(2000);

		doClick(childMenuLocator);
	}

	public static void doClick(By locator) {

		getElement(locator).click();

	}

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");// spice jet didnt work here

		driver.manage().window().fullscreen();

		selectSubMenu("a", "Desktops", "Mac (1)");

	}

}
