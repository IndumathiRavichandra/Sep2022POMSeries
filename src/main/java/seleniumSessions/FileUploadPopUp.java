package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUploadPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		//input(type='filetoupload')

		driver.findElement(By.name("upfile")).sendKeys("C:\\Selenium\\demofiletoupload.txt");
		
			

	}

}
