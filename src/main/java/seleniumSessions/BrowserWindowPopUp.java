package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserWindowPopUp {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(10000);
		
		WebElement twitterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		twitterElement.click();
		
		//child window opens
		//switch driver to child window
		
		Set<String> handles = driver.getWindowHandles();//2 window 
		int windowCount = handles.size();
		System.out.println(windowCount);
		
		Iterator <String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println(parentWindowId);
		String childWindowId = it.next();
		System.out.println(childWindowId);

		// switch work
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);

		System.out.println(driver.getCurrentUrl());
		//close
		driver.close();
		
		//switch back to parent window
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);

		System.out.println(driver.getCurrentUrl());
		//close
		driver.quit();
		
		
	}

}
