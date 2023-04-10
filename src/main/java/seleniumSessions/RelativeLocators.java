package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://www.aqi.in/dashboard/canada");
		
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.linkText("Edmonton, Canada")); 
		
		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(rightIndex);
		
		String lefttIndex = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(lefttIndex);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String nearEleText = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearEleText);
		
	}

}
