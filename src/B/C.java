package B;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Constants;
import Utility.Keywords;
import ru.yandex.qatools.ashot.AShot;

@Listeners(Reporting.class)
public class C {
	Keywords k=new Keywords(Constants.driver);
	AShot a;
	@Test
	public  void ABC() {
		k.openBrowser("chrome");
		k.openURL("https://www.fb.com");
		a=new AShot();
		k.takeScreenShotEntireWebPage(a, Constants.sc);
	}
}
