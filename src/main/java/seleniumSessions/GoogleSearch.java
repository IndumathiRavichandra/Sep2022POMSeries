package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.Thread;
import java.util.List;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread. sleep(1000);
		
	List <WebElement> suggListText =	driver.findElements(By.xpath("//div[@class=\"wM6W7d\"]/span"));
		
	for (WebElement e : suggListText) {
		
		String text = e.getText();
		System.out.println(text);
		
		if(text.contains("selenium webdriver")) {
			e.click();
			break;
		}
		
	}
	}

}
