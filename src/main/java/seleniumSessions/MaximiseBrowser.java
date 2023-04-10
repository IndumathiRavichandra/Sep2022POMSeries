package seleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximiseBrowser {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options); 

		driver.get("http://www.google.com"); 
		System.out.println("launch url");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		
		
		driver.manage().window().minimize();
		
		driver.manage().window().fullscreen();
		
		
		driver.manage().deleteAllCookies();
	}

}
