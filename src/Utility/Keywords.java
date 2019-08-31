package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {
	static WebDriver driver;

	public Keywords(WebDriver driver) {
		Keywords.driver = driver;
	}

	public  void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	public  void openBrowser(String browsername) {
		switch (browsername) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver");
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver");
			driver = new FirefoxDriver();
			break;
		}
		default:
			System.err.println("Invalid Browser : " + browsername);
		}
	}

	public  void openURL(String url) {
		driver.get(url);
	}

	/***
	 * returns a WebElement where type should be in form of
	 * xpath,cssSelector,id,linkText,partialLinkText,className (Case Sensitive)
	 * 
	 * @param type  Eg : xpath,cssSelector,id ,linkText,partialLinkText,className
	 * @param value Eg: //div[@class='u_0_3']
	 * @return {@code WebElement } in the form of
	 *         driver.findElement(By.{@code type(@code value )})
	 *
	 */
	public  WebElement getWebElement(String type, String value) {
		switch (type) {
		case "xpath":
			Constants.element = driver.findElement(By.xpath(value));
			break;
		case "cssSelector":
			Constants.element = driver.findElement(By.cssSelector(value));
			break;
		case "id":
			Constants.element = driver.findElement(By.id(value));
			break;
		case "linkText":
			Constants.element = driver.findElement(By.linkText(value));
			break;
		case "partialLinkText":
			Constants.element = driver.findElement(By.partialLinkText(value));
			break;
		case "className":
			Constants.element = driver.findElement(By.className(value));
			break;
		default:
			System.out.println("Invalid Locator type");
			break;

		}
		return Constants.element;
	}

	public  void clickOnWebElement(String type, String value) {
		getWebElement(type, value).click();
	}

	public  void selectValueFromDropDown(String type, String value, int index) {
		WebElement element = getWebElement(type, value);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public  void closeDriver() {
		driver.close();
	}

	public  WebElement containsText(String tagname, String textContains) {
		Constants.element = driver
				.findElement(By.xpath("//" + tagname + "[contains(text(),'" + textContains + "')]"));
		return Constants.element;
	}

	public  void applythreaddotsleep(long timeInMS) throws InterruptedException {
		Thread.sleep(timeInMS);
	}

	public  void applyImplicitWait(int timeinSeconds) {
		driver.manage().timeouts().implicitlyWait(timeinSeconds, TimeUnit.SECONDS);
	}
	public  Set<String> getWindowHandles(){
		return driver.getWindowHandles();
	} 
	public void switchWindow(String windowname) {
		driver.switchTo().window(windowname);
	}
	public void takeScreenShotEntireWebPage(AShot a,Screenshot sc) {
		Date d = new Date();
		sc = a.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		try {
			ImageIO.write(sc.getImage(), "JPG", new File(
					"./ScreenShotImages/" + d.toString() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
