package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BackFwdSimulation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options); 

		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

		
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getTitle());
		
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
	}

}
