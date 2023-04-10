package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertHandling {
	
		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			
			


		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		
		String text= alert.getText();
		System.out.println(text);
		
		Thread.sleep(4000);

		alert.accept();
			
	}

}

