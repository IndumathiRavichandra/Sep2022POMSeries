package seleniumSessions;

import java.awt.Frame;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		List <WebElement> frameList =driver.findElements(By.tagName("frame"));
		System.out.println(frameList.size());
		
		//driver.switchTo().frame("main");
		//driver.switchTo().frame(2); prefer xpath
		
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().parentFrame();	}

}
