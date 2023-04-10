package seleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class QuitVsClose {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com");
		System.out.println("launch chrome");
		System.out.println(driver.getTitle());
		driver.quit();
		
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println("launch chrome");
		System.out.println(driver.getTitle());
		
		driver.close();
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println("launch chrome");
		System.out.println(driver.getTitle());
		
	}

}
