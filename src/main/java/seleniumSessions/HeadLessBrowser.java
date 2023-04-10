package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {// Not suggested

	public static void main(String[] args) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			options.addArguments("--headless");
			//options.setHeadless(true);

			WebDriver driver = new ChromeDriver(options);
			
			driver.get("https://www.google.com");
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			
			driver.quit();
		
	}

}
