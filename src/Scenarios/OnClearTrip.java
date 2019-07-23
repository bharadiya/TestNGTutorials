package Scenarios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnClearTrip {
	public static WebDriver driver = null;
	private static Scanner sc;

	public static void main(String[] args) throws InterruptedException {
		sc = new Scanner(System.in);
		System.out.println("Enter day for onward journey");

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		driver = new ChromeDriver();

		// Task 1

		driver.get("https://www.cleartrip.com");
		WebDriverWait explicitWait = new WebDriverWait(driver, 40);
		WebElement roundTrip = driver.findElement(By.xpath("//input[@id='RoundTrip']"));
		explicitWait.until(ExpectedConditions.elementToBeClickable(roundTrip));
		roundTrip.click();

		// Task 2

		WebElement From = driver.findElement(By.xpath("//input[@id='FromTag']"));
		WebElement To = driver.findElement(By.xpath("//input[@id='ToTag']"));
		Thread.sleep(3000);
		From.sendKeys("BOM");
		Thread.sleep(3000);
		// From.sendKeys(Keys.ARROW_DOWN);
		From.sendKeys(Keys.ENTER);
		To.sendKeys("DEL");
		Thread.sleep(3000);
		// To.sendKeys(Keys.ARROW_DOWN);
		To.sendKeys(Keys.ENTER);

		// Task 3

		WebElement FromDate = driver.findElement(By.xpath("//input[@id='DepartDate']"));
		WebElement ToDate = driver.findElement(By.xpath("//input[@id='ReturnDate']"));
		String[] fromdate = getNextDate(90);
		String[] returnDate = getNextDate(95);
		FromDate.click();
		executeCalander(fromdate[0], fromdate[1], fromdate[2]);
		Thread.sleep(1000);
		ToDate.click();
		executeCalander(returnDate[0], returnDate[1], returnDate[2]);
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='SearchBtn']"));
		searchBtn.click();
		Thread.sleep(15000);
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"((//ul[@class='listView flights'])[2]//img[@title='Vistara'])[2]/parent::span/parent::th/preceding-sibling::th/child::input"))));
		// Task 4

		List<WebElement> numberofFlights = driver
				.findElements(By.xpath("(//ul[@class='listView flights'])[2]//img[@title='Vistara']"));
		System.out.println(numberofFlights.size());
		if (numberofFlights.size() > 1) {
			explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
					"((//ul[@class='listView flights'])[2]//img[@title='Vistara'])[2]/parent::span/parent::th/preceding-sibling::th/child::input"))));
			driver.findElement(By.xpath(
					"((//ul[@class='listView flights'])[2]//img[@title='Vistara'])[2]/parent::span/parent::th/preceding-sibling::th/child::input"))
					.click();
			explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
					"((//ul[@class='listView flights'])[3]//img[@title='Vistara'])[2]/parent::span/parent::th/preceding-sibling::th/child::input"))));
			driver.findElement(By.xpath(
					"((//ul[@class='listView flights'])[3]//img[@title='Vistara'])[2]/parent::span/parent::th/preceding-sibling::th/child::input"))
					.click();
			// Task 5

			driver.findElement(By.xpath(
					"//div[@id='ResultContainer_1_1']//button[@class='booking fRight'][contains(text(),'Book')]"))
					.click();

			// Task 6

			WebElement acceptTerms = driver.findElement(By.xpath("//input[@id='insurance_confirm']"));
			explicitWait.until(ExpectedConditions.elementToBeClickable(acceptTerms));
			acceptTerms.click();
			driver.findElement(By.xpath("//input[@id='itineraryBtn']")).click();

			// Task 7

			WebElement enterEmail = driver.findElement(By.xpath("//input[@id='username']"));
			explicitWait.until(ExpectedConditions.elementToBeClickable(enterEmail));
			enterEmail.sendKeys("s.b@gmail.com");
			driver.findElement(By.xpath("//input[@id='LoginContinueBtn_1']")).click();

			// Task 8

			WebElement firstName = driver
					.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='AdultFname1']"));
			explicitWait.until(ExpectedConditions.elementToBeClickable(firstName));
			firstName.sendKeys("SB");

			WebElement title = driver.findElement(By.cssSelector("#AdultTitle1"));
			Select s = new Select(title);
			s.selectByIndex(1);

			WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
			lastName.sendKeys("BH");

			WebElement mobileNo = driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']"));
			mobileNo.sendKeys("9865986526");

			driver.findElement(By.cssSelector("#travellerBtn")).click();

			// Task 9
			Thread.sleep(15000);
			WebElement netBankingButton = driver.findElement(By.xpath("//a[contains(text(),'Net Banking')]"));
			explicitWait.until(ExpectedConditions.elementToBeClickable(netBankingButton));
			netBankingButton.click();

			driver.findElement(By.xpath("//input[@id='kotak_bank']")).click();
			driver.findElement(By.cssSelector("#paymentSubmit")).click();

			// Task 10
			Thread.sleep(30000);
			WebElement crn = driver.findElement(By.xpath("//input[@id='crn']"));
			explicitWait.until(ExpectedConditions.elementToBeClickable(crn));

			if (driver.getTitle().contains("Kotak Mahindra")) {
				System.out.println("User is on Kotak Mahindra Bank Page");
			}
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("This flight is not available");
			}
		}
	}

	public static String[] getNextDate(int noofDays) {
		String[] ddmmyyyy = new String[3];
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, noofDays);
		Date nextdate = cal.getTime();
		String nextDateinString = nextdate.toString();
		String[] res = nextDateinString.split("\\s");
		ddmmyyyy[0] = res[2]; // day
		int month = nextdate.getMonth();
		ddmmyyyy[1] = Integer.toString(month);
		ddmmyyyy[2] = res[5]; // year
		return ddmmyyyy;
	}

	public static void executeCalander(String day, String month, String year) {
		while (true) {
			try {
				driver.findElement(By.xpath(
						"(//td[@data-month='" + month + "' and @data-year='" + year + "'])/a[text()='" + day + "']"))
						.click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("(//a[@title='Next'])[2]")).click();
			}
		}
	}
}
