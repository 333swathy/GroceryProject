package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public int random(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public static void selectCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static void deselectCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static boolean isCheckboxSelected(WebElement checkbox) {
		return checkbox.isSelected();
	}

	public static void hoverOverElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Right-click (context click) on an element
	public static void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Double-click on an element
	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// Drag and drop from source element to target element
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// Click and hold an element (useful for drag operations)
	public static void clickAndHold(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	// Release an element after click and hold
	public static void releaseElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.release(element).perform();
	}

	// Send keys using Actions (useful for keyboard interactions)
	public static void sendKeysUsingActions(WebDriver driver, WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(text).perform();
	}

	// Switch to frame by index
	public static void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// Switch to frame by name or ID
	public static void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch to frame using a WebElement
	public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch back to default content (exit iframe)
	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Switch to the parent frame (useful when inside nested iframes)
	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public static boolean searchElementInTable(WebDriver driver, List<WebElement> tableElement, String searchText) {

		List<WebElement> tableRows = driver.findElements(By.tagName("tr"));

		for (WebElement row : tableRows) {
			if (row.getText().contains(searchText)) {
				System.out.println("Element found: " + row.getText());
				return true;
				
			}
			
		}

		System.out.println("Element not found.");
		return false;
	}

	public void uploadImage(WebElement imageupload, String imagePath) {
		imageupload.sendKeys(imagePath);

	}

	public void selectRadioButton(WebElement radiobutton) {
		if (!radiobutton.isSelected()) {
			radiobutton.click();
		}
	}

	// Method to scroll down and click an element
	public void scrollDownAndClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Scroll down by 300 pixels (adjust as needed)
			js.executeScript("window.scrollBy(0,500);");
			Thread.sleep(1000); // Allow time for scrolling
			element.click();
		} catch (Exception e) {
			System.out.println("Error clicking element: " + e.getMessage());
		}
	}

}
