package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class CategoryPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtilities waitutility = new WaitUtilities();
	FileUploadUtility fileupload = new FileUploadUtility();

	public CategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newCategoryButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryNameField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discountField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageFiled;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement topMenuRadioButton;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement leftMenuRadioButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchInputField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonForInput;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileForEdit;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertmessage;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement statusbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newCategryAlert;

	public CategoryPage clickOnNewCategoryButton() {
		waitutility.waitUntilElementToBeClickable(driver, newCategoryButton);
		pageutility.clickJavaScriptExecutor(newCategoryButton, driver);
		// newCategoryButton.click();
		return this;

	}

	public CategoryPage enterNameOnCategoryField() {
		String category_name = "Accessories" + pageutility.generateCurrentDateAndTime();
		categoryNameField.sendKeys(category_name);
		return this;
	}

	public CategoryPage clickOnDiscountField() {
		waitutility.waitUntilElementToBeClickable(driver, discountField);
		pageutility.clickJavaScriptExecutor(discountField, driver);
		return this;
	}

	public CategoryPage uploadImageOnImageField() throws AWTException

	{

		String image = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\norweign woods.jpg";
		fileupload.fileuploadusingsendkeys(imageFiled, image);
		waitutility.waitForImageToBeVisible(driver, imageFiled);
		return this;

	}

	public CategoryPage clicktopMenuRadioButton() {
		pageutility.selectRadioButton(topMenuRadioButton);
		return this;
	}

	public CategoryPage clickLeftMenuRadioButton() {
		pageutility.selectRadioButton(leftMenuRadioButton);
		return this;
	}

	public CategoryPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(saveButton, driver);
		waitutility.waitUntilElementToBeClickable(driver, saveButton);
		return this;
	}

	public CategoryPage clickOnSearchButton() {
		pageutility.clickJavaScriptExecutor(searchButton, driver);
		return this;
	}

	public CategoryPage clickOnEditButton() {
		pageutility.clickJavaScriptExecutor(editButton, driver);
		return this;
	}

	public CategoryPage chooseNewImage() throws AWTException {
		String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\harukki.jpg";
		//pageutility.clickJavaScriptExecutor(imageFiled, driver);
		//String image2 = "C:\\Users\\GOKUL\\git\\GroceryProject\\GroceryApplication\\src\\test\\resources\\images\\harukki.jpg";
		fileupload.fileuploadusingsendkeys(chooseFileForEdit, image2);
		//waitutility.waitForImageToBeVisible(driver, chooseFileForEdit);
		return this;
	}

	public CategoryPage clickOnUpdateButton() {
		pageutility.clickJavaScriptExecutor(updateButton, driver);
		//waitutility.waitUntilElementToBeClickable(driver, updateButton);
		return this;
	}

	public boolean isAlertDisplayed() {
		return updateAlertmessage.isDisplayed();
	}

	public CategoryPage clickOnStatusButton() {
		pageutility.clickJavaScriptExecutor(statusbutton, driver);
		return this;
	}

	public boolean isAlertDisplayedForStatus() {
		return statusAlertMessage.isDisplayed();
	}
	public boolean isAlertDisplayedForNewCategory() {
		return newCategryAlert.isDisplayed();
	}
}
