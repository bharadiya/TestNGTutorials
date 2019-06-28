package Scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimesOfIndia {
	WebDriver driver = null;

	@Test
	public void clickAllLinks() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//home//sb//Desktop//BackUp//Downloads//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/");
		try {
			driver.findElement(By.xpath("//a[contains(text(),'click here to')]"));
		} finally {
			Thread.sleep(10000);
			List<WebElement> list = driver.findElements(
					By.xpath("//*[contains(text(),'TOP NEWS STORIES')]/following-sibling::*[1]/child::li"));
			System.out.println(list.size());
			for (int i = 1; i <= list.size(); i++) {
				String combination = Keys.chord(Keys.CONTROL, Keys.ENTER);
				driver.findElement(By.xpath(
						"//*[contains(text(),'TOP NEWS STORIES')]/following-sibling::*[1]/child::li[" + i + "]/a"))
						.sendKeys(combination);
				Thread.sleep(1000);
			}
			Set<String> AllHandles = driver.getWindowHandles();
			System.out.println(AllHandles.size());
			ArrayList<String> A = new ArrayList<String>(AllHandles);
			for (int i = A.size() - 1; i >= 0; i--) {
				driver.switchTo().window(A.get(i));
				Thread.sleep(1000);
				System.out.println(driver.getTitle());
			}

		}
	}
}
