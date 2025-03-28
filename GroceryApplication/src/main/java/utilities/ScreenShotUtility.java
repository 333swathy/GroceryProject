package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;// driver object cast to take screenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//Captures the screenshot and saves it as a temporary file.

		File f1 = new File(System.getProperty("user.dir") + "\\OutputScreenshots");
		if (!f1.exists()) {

			f1.mkdirs();// create folder using java for storing
		}

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File finalDestination = new File(
				System.getProperty("user.dir") + "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);// copying from temp path to final destination
	}

}
