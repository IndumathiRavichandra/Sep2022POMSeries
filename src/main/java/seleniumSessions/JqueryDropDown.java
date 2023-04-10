package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JqueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);

		By ddLocator = By.xpath("//span[@class='comboTreeItemTitle']");

		// 1------- single selection in drop down
		 selectChoice(ddLocator, "choice 1");

		// 2------- multiple selection in drop down
		//selectChoice(ddLocator, "choice 1", "choice 2", "choice 3", "choice 6 2 3");

		// 3------- All selection in drop down
		// selectChoice(ddLocator, "all");

		// 4------- Invalid Selection in drop down
		// selectChoice(ddLocator, "choice 9");

	}

	
	/**
	 * this method is handling single, multiple and all choices selection
	 * this method is also handling if choice is not available.
	 * please pass the choices which are present in case of multiple choice selection
	 * @param locator
	 * @param choice
	 */
	
	public static void selectChoice(By locator, String... choice) {

		List<WebElement> ddList = driver.findElements(locator);

		boolean flag = false;

		if (!choice[0].equalsIgnoreCase("all")) {

			for (WebElement e : ddList) {

				String text = e.getText();
				System.out.println(text);
				for (int i = 0; i < choice.length; i++) {

					// System.out.println(text);
					if (text.equals(choice[i])) {
						flag = true;
						e.click();
						break;
					}

				}
			}

		} else {
			// all selection logic
			try {
				

				for (WebElement e : ddList) {
					String text = e.getText();
					System.out.println(text);
					
					e.click();
					flag = true;
				}
			} catch (Exception e) {
			}

		}

		if (flag == false) {

			System.out.println("Choice not available " + choice[0]);
		}

	}

	// int count = ddList.size();
	// System.out.println(count);

}
