package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WaitforPageLoadConcept {

	static WebDriver driver;

	public static void waitforPageLoad(int timeOut) {

		long endTime = System.currentTimeMillis() + timeOut;

		while (System.currentTimeMillis() < endTime) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String pageState = js.executeScript("return document.readyState").toString();

			if (pageState.equals("complete")) {

				System.out.println("Page DOM is fully loaded");
				break;
			}

		}

	}

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://classic.freecrm.com/pricing.html");

		waitforPageLoad(10);
	}

}
