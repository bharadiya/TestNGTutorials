package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GetScreenShot {
	AShot a=new AShot();
	Screenshot sc;
	WebDriver driver;
	public GetScreenShot(WebDriver driver){
		this.driver=driver;
	}
	public void takeScreenShotEntireWebPage() {
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
