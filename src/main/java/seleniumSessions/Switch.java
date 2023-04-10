package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Switch {

	public static void main(String[] args) {
		String browser = "chrome";

		WebDriver driver;

		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			driver.get("https://www.google.com");

			System.out.println("launch chrome");

			driver.close();

			break;

		case "ff":
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.get("https://www.google.com");

			System.out.println("launch ff");

			driver.close();

			break;

		case "safari":
			System.out.println("cannot launch safari");
			break;

		case "edge":
			System.out.println("entered launch edge");
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Java\\msedgedriver.exe");

			driver = new EdgeDriver();
			driver.get("https://www.google.com");

			System.out.println("launch edge");
			driver.close();
			break;

		default:
			System.out.println("pls pass the right browser " + browser);
			break;
		}

	}

}
