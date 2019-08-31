package Scenarios;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Utility.Constants;
import Utility.Keywords;

public class RedBusWindowHandle {
	Keywords k = new Keywords(Constants.driver);

	@Test
	public void clickAllLinks() throws InterruptedException {
		k.openBrowser("chrome");
		k.openURL("https://www.redbus.in");
		k.applythreaddotsleep(5000);
		String combinationString = Keys.chord(Keys.CONTROL, Keys.ENTER);
		k.containsText("a", "Singapore").sendKeys(combinationString);
//		k.containsText("a", "Malaysia").sendKeys(combinationString);
//		k.containsText("a", "Peru").sendKeys(combinationString);
//		k.containsText("a", "Indonesia").sendKeys(combinationString);
//		k.containsText("a", "India").sendKeys(combinationString);
		Set<String> windowhandles = k.getWindowHandles();
		System.out.println(windowhandles.size());
//		ArrayList<String>A=new ArrayList<String>(windowhandles);
//		for (int i = A.size()-1; i >= 0; i--) {
//			k.switchWindow(A.get(i));
//			k.applythreaddotsleep(500);
//		}
	}
}
