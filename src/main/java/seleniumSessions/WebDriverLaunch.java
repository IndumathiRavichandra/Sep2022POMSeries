package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverLaunch {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver1 = new ChromeDriver(options);//launch 1 browser
		
		//driver= null;
		
		WebDriver driver2 = new ChromeDriver(options);//launch 2nd browser
		WebDriver driver3 = new ChromeDriver(options);//launch 3rd browser
		
		driver1.get("https://www.google.com"); 
		
		
		driver2.get("https://www.amazon.com");
		
		
		
		driver3.get("https://www.flipkart.com");
	
		driver1 = driver2;
		
		System.out.println(driver1.getTitle());
		System.out.println(driver2.getTitle());
		System.out.println(driver3.getTitle());
		
		
		System.out.println(driver1.getCurrentUrl());
		
		driver1.quit();
		
	}

}
