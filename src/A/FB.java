package A;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://fb.com");
		driver.findElement(By.xpath("//input[@id='email'] | //input[@id='pass']")).sendKeys("hi");
	}
}
