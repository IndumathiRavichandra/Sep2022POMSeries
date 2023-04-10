package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("http://seleniumpractise.blogspot.com/2016/");

		driver.findElement(By.id("datepicker")).click();
		
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);

		selectDate("4");
		//selectCalenderDate("16");
	}

	public static void selectCalenderDate(String day) {

		List<WebElement> daysList = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		System.out.println(daysList.size());
		
		for(WebElement e: daysList) {
			
			String text = e.getText();
			if(text.equals(day)) {
				
				e.click();
				break;
			}
		}
	}

	/**
	 * Above method is easier comparitively
	 * @param day
	 */
	public static void selectDate(String day) {

		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

}
