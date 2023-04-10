package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
		WebElement e1 = driver.findElement(By.linkText("MacBook111"));
		System.out.println(e1.getAttribute("href"));
		//e2--- 10 seconds
		//e3--- 10 seconds
		//e4--- 10 seconds
		
		//login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//e5,e6,e7------20 seconds
		
		//home page
		//e8,e9------20 seconds
		

		//login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//e10,e11------30 seconds-overrride
	}

	}
