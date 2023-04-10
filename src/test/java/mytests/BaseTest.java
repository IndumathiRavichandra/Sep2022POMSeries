package mytests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver;

	@Parameters({ "url", "browser","headless" })// remove headless if you want to execute without browser
	@BeforeTest
	public void setup(String url, String browser, String headless) {// remove headless if you want to execute without browser

		System.out.println("launching browser ... " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//options.setHeadless(Boolean.parseBoolean(headless));
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		} else {

			System.out.println("pass the right browser");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
