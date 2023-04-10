package seleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindowConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkedin)).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		
//		WebElement lknElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
//		lknElement.click();
//		
		
		
		Set<String> handles = driver.getWindowHandles();//2 window 
		Iterator <String> it = handles.iterator();
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId);
		
	}

}
