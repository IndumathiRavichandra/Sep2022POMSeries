package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomWait {

	static WebDriver driver;

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	public static WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {

			try {

				element = getElement(locator);
				System.out.println("Element is found in attempt : " + attempts);
				break;
			}

			catch (NoSuchElementException e) {

				System.out.println("Element is not found in attempt : " + attempts + " for " + locator);

				try {

					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}

			attempts++;

		}

		if (element == null) {

			System.out.println(
					"element is not found... tried for : " + timeOut + "secs" + " with the interval of 500 milli sec");
			throw new FrameworkException("TimeOutException");

		}

		return element;

	}

	// METHOD OVERLOAD
	public static WebElement retryingElement(By locator, int timeOut, int intervalTime) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {

			try {

				element = getElement(locator);
				System.out.println("Element is found in attempt : " + attempts);
				break;
			}

			catch (NoSuchElementException e) {

				System.out.println("Element is not found in attempt : " + attempts);

				try {

					Thread.sleep(intervalTime * 1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}

			attempts++;

		}

		if (element == null) {

			System.out.println("element is not null... tried for : " + timeOut + " secs" + " with the interval of  "
					+ intervalTime + " secs");
			throw new FrameworkException("TimeOutException");

		}

		return element;

	}

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://classic.freecrm.com/register/");

		By fName = By.xpath("//input[@name='first_name11']");

		retryingElement(fName, 10, 2).sendKeys("indu"); // every 2 sec it will check
	}

}
