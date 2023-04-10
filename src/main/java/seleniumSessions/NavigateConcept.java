package seleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigateConcept {

	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options); // open browser

		driver.get("http://www.google.com"); // Another way to launch browser.

		//driver.navigate().to("http://www.amazon.com");
		driver.navigate().to(new URL("http://www.amazon.com"));

		System.out.println("launch url");

		String title = driver.getTitle();

		System.out.println("title is " + title);
		if (title.contains("Amazon")) {

			System.out.println("Correct title");
		}

		else {
			System.out.println("InCorrect title");
		}

		 driver.quit();

	}

}
