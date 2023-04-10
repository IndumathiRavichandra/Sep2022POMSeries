package assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");// spice jet didnt work here

		driver.manage().window().fullscreen();

		selectSubMenu("Components", "Monitors (2)");
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static void selectSubMenu(String parentMenu, String childMenu) throws InterruptedException {

		By parentMenuLocator = By.xpath("//a[text()='" + parentMenu + "']");
		By childMenuLocator = By.xpath("//a[text()='"+childMenu+"']");

		WebElement compLocator = getElement(parentMenuLocator);
		Actions act = new Actions(driver);
		act.moveToElement(compLocator).build().perform();
		Thread.sleep(3000);

		doClick(childMenuLocator);

	}
	
	public static void doClick(By locator) {
		
		getElement(locator).click();
		
	}

}
