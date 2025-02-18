package utilities;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static int implicitWaitDuration=10;
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	
	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitUntilElementIsVisible(WebDriver driver,WebElement element)
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitUntilElementframeToBeAvailableAndSwitchToIt(WebDriver driver,String frame)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}
	public void waitForImageToBeVisible(WebDriver driver,WebElement imageElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitDuration));
        wait.until(ExpectedConditions.visibilityOf(imageElement));
	}
// add conditions

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
	}
	
}
