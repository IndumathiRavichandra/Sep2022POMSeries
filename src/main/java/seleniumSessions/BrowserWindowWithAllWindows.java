package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserWindowWithAllWindows {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			Thread.sleep(10000);
			
			String parentWindowId = driver.getWindowHandle();
			
			WebElement lknElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
			WebElement fbElement = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
			WebElement twitterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
			WebElement ytbElement = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
			
			lknElement.click();
			fbElement.click();
			twitterElement.click();
			ytbElement.click();
			
			//child window opens
			//switch driver to child window
			
			Set<String> handles = driver.getWindowHandles();//2 window 
			Iterator <String> it = handles.iterator();
			
			while (it.hasNext()) {
				
				String windowId = it.next();
				driver.switchTo().window(windowId);
				driver.getCurrentUrl();
				Thread.sleep(2000);
				
				if(!windowId.equals(parentWindowId)) {
					driver.close();
				}
			}
			
			
			driver.switchTo().window(parentWindowId);

			System.out.println(driver.getTitle());

		}

	}
