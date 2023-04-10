package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AllAlertsType {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		WebElement jsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

		jsAlert.click();
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println(text1);
		Thread.sleep(4000);
		alert1.accept();

		jsConfirm.click();
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		System.out.println(text2);
		Thread.sleep(4000);
		alert2.dismiss();

		jsPrompt.click();
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println(text3);
		Thread.sleep(4000);
		alert3.sendKeys("hello testing");
		Thread.sleep(5000);
		alert3.accept();

	}

}
