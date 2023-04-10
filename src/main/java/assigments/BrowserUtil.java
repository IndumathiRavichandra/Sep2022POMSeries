package assigments;

//import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumSessions.FrameworkException;

public class BrowserUtil {
	WebDriver driver;

	public WebDriver launchBrowser(String browserName) {

		System.out.println("browserName is :" + browserName);

		switch (browserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

			System.out.println("launch chrome");
			break;

		case "firefox":
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.get("https://www.google.com");

			System.out.println("launch ff");

			break;

		case "safari":
			System.out.println("cannot launch safari");
			break;

		case "edge":
			System.out.println("entered launch edge");
			System.setProperty("webdriver.edgedriver.driver", "C:\\Program Files\\Java\\msedgedriver.exe");

			driver = new EdgeDriver();
			driver.get("https://www.google.com");

			System.out.println("launch edge");

			break;

		default:
			System.out.println("pls pass the right browser " + browserName);
			break;
		}

		return driver;
	}

	public void launchUrl(String url) {

		if (url == null) {
			System.out.println("url is null");
			throw new FrameworkException("url is null");
		}

		if (url.length() == 0) {
			System.out.println("url is blank");
			throw new FrameworkException("url is blank and empty");
		}
		if (url.indexOf("http") != 0 && url.indexOf("https") != 0) {

			System.out.println("No http - http is missing");
			throw new FrameworkException("Http(s) is missing");
		}

		driver.get(url);

		System.out.println(driver.getCurrentUrl());

	}

	public String getPageTitle() {

		return driver.getTitle();
	}
	
	public void screenMax() {
		driver.manage().window().fullscreen();
	}

	public void Quit() {

		driver.quit();
	}

	public void closeBrowser() {

		driver.close();
	}

}
