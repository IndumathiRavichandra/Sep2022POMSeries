package seleniumSessions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CricInfoTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get(
				"https://www.espncricinfo.com/series/icc-cricket-world-cup-qualifier-play-off-2023-1365085/namibia-vs-jersey-6th-match-1365097/full-scorecard");

	//	String WicketTakerName = driver.findElement(By.xpath("//span[text()='Josh Lawrenson']/ancestor::td/following-sibling::td[contains(@class,'ds-hidden')]")).getText();
		
		
		
		String WicketTakerName = getWicketTakerName("Josh Lawrenson");
		System.out.println(WicketTakerName);
	}

	public static String getWicketTakerName(String playerName) {
		return driver.findElement(By.xpath("(//span[contains(text(),'"+playerName+"')]/ancestor::td/following-sibling::td)[1]")).getText();
		
	}

}
