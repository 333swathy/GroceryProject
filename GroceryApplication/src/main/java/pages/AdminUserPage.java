package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class AdminUserPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtilities waitutility = new WaitUtilities();
	FakerUtility fakerutility = new FakerUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newAdminUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt'][1]")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlertMessgae;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertMessage;
	// @FindBy(xpath = "//a[@class='btn btn-sm btn btn-success
	// btncss'][1]")WebElement statusUnlock;
	@FindBy(xpath = "//a[@role='button']")
	List<WebElement> statusUnlock;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlertMessage;

	public AdminUserPage clickOnnewAdminUserButton() {
		pageutility.clickJavaScriptExecutor(newAdminUserButton, driver);
		return this;
	}

	public AdminUserPage enterNewUsernameOnField() {
		usernameField.clear();
		// String user_name = "swathy" + pageutility.generateCurrentDateAndTime();
		String user_name = fakerutility.generateName();
		usernameField.sendKeys(user_name);
		return this;
	}

	public AdminUserPage enterNewPasswordOnField() {
		passwordField.clear();
		passwordField.sendKeys("swathy");
		return this;
	}

	public AdminUserPage chooseTypeFromTypeDropdown() {
		pageutility.selectDropdownWithVisibleText(userTypeDropDown, "Partner");
		return this;
	}

	public AdminUserPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(saveButton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

	public AdminUserPage clickDeleteButtonOfUserList() {
		pageutility.clickJavaScriptExecutor(deleteButton, driver);
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertDisplayed2() {
		return deleteAlertMessgae.isDisplayed();
	}

	public AdminUserPage clickOnEditButton() {
		pageutility.clickJavaScriptExecutor(editButton, driver);
		waitutility.waitUntilElementToBeClickable(driver, editButton);
		return this;
	}

	public AdminUserPage clickOnUpdateButton() {
		pageutility.clickJavaScriptExecutor(updateButton, driver);
		return this;
	}

	public boolean isAlertDisplayed3() {
		return updateAlertMessage.isDisplayed();
	}

	public AdminUserPage clickOnStatusFirstSuccessButton()// clickFirstSuccessButton
	{
		waitutility.waitUntilElementToBeClickable(driver, statusUnlock.get(0));
		// Click first button
		pageutility.clickJavaScriptExecutor(statusUnlock.get(0), driver);
		return this;
	}

	public boolean isAlertDisplayed4() {
		return updateAlertMessage.isDisplayed();
	}

}
