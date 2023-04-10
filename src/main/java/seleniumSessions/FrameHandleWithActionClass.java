package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameHandleWithActionClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://classic.crmpro.com/index.html");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
			
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame("mainpanel");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).build().perform();
		act.click(driver.findElement(By.linkText("New Contact"))).build().perform();
		
		driver.findElement(By.id("first_name")).sendKeys("Abasd");
	//	driver.quit();
		
	}

}
