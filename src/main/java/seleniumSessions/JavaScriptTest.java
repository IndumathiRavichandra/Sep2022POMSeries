package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);

//		String uri = js.executeScript("return document.baseURI").toString();
//		System.out.println(uri);
//		

		JavaScriptUtil util = new JavaScriptUtil(driver);
		String title1 = util.getTitleByJS();
		System.out.println(title1);

		Thread.sleep(2000);
		util.goBackByJS();
		util.goForwardByJS();
		util.refreshBrowserByJS();

		String pageText = util.getPageInnerText();
		System.out.println(pageText);

		if (pageText.contains("naveenopencart")) {

			System.out.println("PASS");
		}
//		util.generateAlert("hello");

//		util.generateConfirmPopUp("hi");
		
		util.scrollPageDown();
		Thread.sleep(2000);

		util.scrollPageUp();
		Thread.sleep(2000);

		WebElement emailId = driver.findElement(By.id("input-email"));
		util.drawBorder(emailId);
		
		WebElement rightPanel = driver.findElement(By.id("column-right"));
		util.drawBorder(rightPanel);
		
//		util.flash(emailId);
//		emailId.sendKeys("indu@gmail.com");
//		util.flash(rightPanel);
//		util.scrollIntoView(WebElement element);


	}

}
