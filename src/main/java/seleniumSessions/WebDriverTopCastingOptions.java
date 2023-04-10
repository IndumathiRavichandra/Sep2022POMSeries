package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverTopCastingOptions   {

	public static void main(String[] args) {

		// 2 top casting
		System.out.println(
				"chrome-----------------ChromeDriver driver1 = new ChromeDriver(options);--------------------");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver1 = new ChromeDriver(options);

		driver1.get("https://www.google.com");
		System.out.println("launch chrome");
		driver1.close();

		// 3 top casting

		System.out.println("edge-------------------------RemoteWebDriver driver3 = new EdgeDriver();------------");

		RemoteWebDriver driver3 = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Java\\msedgedriver.exe");

		driver3.get("https://www.google.com");
		System.out.println("launch Edge browser");

		driver3.close();

		// 1 top casting
		System.out.println("firefox-------WebDriver driver = new FirefoxDriver();------------------------------");

		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\geckodriver.exe");

		driver.get("https://www.google.com");
		System.out.println("launch ff");

		driver.close();

	}

}









