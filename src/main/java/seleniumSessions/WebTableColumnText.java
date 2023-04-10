package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WebTableColumnText {

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

		driver.findElement(By.linkText("CONTACTS")).click();

		
		System.out.println("Company name" + getUserCompanyName("Romi singh"));
		
		System.out.println("Company name" + getUserCompanyName("Ali khan"));
		
		
	}

	public static String getUserCompanyName(String userName) {

		return driver
				.findElement(By
						.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td/a[@context='company']"))
				.getText();
	}

}
