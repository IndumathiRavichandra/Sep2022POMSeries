package seleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	WebDriver driver;

	public WebDriver launchBrowser(String browserName) {

		System.out.println("browserName is :" + browserName);

		switch (browserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			//driver.get("https://www.google.com");

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
		
		if(url.length()==0) {
			System.out.println("url is blank");
			throw new FrameworkException("url is blank and empty");
		}
		
//		if(url.contains("http")) {
//			System.out.println("url is blank");
//			throw new FrameworkException("url is blank and empty");
//		}

		//if(url.contains("http")) better to write below one
		
		if(url.indexOf("http")!=0 && url.indexOf("https")!=0) {
			
			System.out.println("No http - http is missing");
			throw new FrameworkException("Http(s) is missing");
		}
		

		driver.get(url);

		System.out.println(driver.getCurrentUrl());

	}

	
	public void launchUrl(URL url) {

		
		String newUrl = String.valueOf(url);
		if (newUrl == null) {
			System.out.println("url is null");
			throw new FrameworkException("url is null");
		}
		
		if(newUrl.length()==0) {
			System.out.println("url is blank");
			throw new FrameworkException("url is blank and empty");
		}
		
		if(newUrl.indexOf("http")!=0 && newUrl.indexOf("https")!=0) {
			
			System.out.println("No http - http is missing");
			throw new FrameworkException("Http(s) is missing");
		}
		

		driver.get(newUrl);

		System.out.println(driver.getCurrentUrl());

	}

	
	
	public String getPageTitle() {

		return driver.getTitle();
	}

	public void closeBrowser() {

		driver.quit();
	}

}
