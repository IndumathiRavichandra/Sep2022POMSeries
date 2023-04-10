package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetTextFieldValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement emailId = driver.findElement(By.id("input-email"));
		emailId.sendKeys("indu@gmail.com");
		
		String val = emailId.getAttribute("value");
		System.out.println(val);
	}

}
