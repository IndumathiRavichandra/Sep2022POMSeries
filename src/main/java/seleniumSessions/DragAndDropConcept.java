package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");

		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		
		//act.dragAndDrop(sourceEle, targetEle).build().perform();
		
		
	}

}
