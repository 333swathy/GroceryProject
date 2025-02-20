package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class SubcategoryPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtilities waitutility = new WaitUtilities();
	FileUploadUtility fileupload = new FileUploadUtility();

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newSubCategoryButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryField;
	// @FindBy(xpath="//li//p[text()='Sub Category']")WebElement subCategoryField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchDropdown;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtobForSelectDropdown;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[2]")
	WebElement tableElement;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageupload;
	@FindBy(xpath = "//a[@role='button']")
	WebElement activeButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subCategoryField1;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonOnList;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessageOfActiveStatus;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categoryDropdownForSearch;

	public SubcategoryPage clickOnNewSubCategoryButton() {
		newSubCategoryButton.click();
		return this;
	}

	public SubcategoryPage clickOnCategoryDropdown() {

		pageutility.selectDropdownWithVisibleText(categoryDropdown, "Toys");
		return this;
	}

	public SubcategoryPage clickOnSubCategoryField() {
		String subcategoryname = "TeddyBear" + pageutility.generateCurrentDateAndTime();
		subCategoryField.sendKeys(subcategoryname);
		return this;

	}

	public SubcategoryPage imageUploadInSubcategory() {
		String file = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\images\\cute-teddy-bear-with-red-heart-balloons-on-wooden-floor-and-sparkling-background-photo.jpg";
		fileupload.fileuploadusingsendkeys(imageupload, file);
		waitutility.waitForImageToBeVisible(driver, imageupload);
		return this;
	}

	public SubcategoryPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(saveButton, driver);
		return this;
	}

	public boolean isAlertDisplayed() { 
		return alertMessage.isDisplayed();
	}

	public SubcategoryPage clickOnSearchButton() {
		pageutility.clickJavaScriptExecutor(searchbutton, driver);
		return this;

	}

	public SubcategoryPage clickOnSeachDropdown() {

		pageutility.selectDropdownWithVisibleText(searchDropdown, "Toys");
		waitutility.waitUntilElementIsVisible(driver, searchDropdown);
		return this;
	}

	public SubcategoryPage clickOnsearchButtonForSelectDropdown() {
		searchButtobForSelectDropdown.click();
		waitutility.waitUntilElementIsVisible(driver, searchButtobForSelectDropdown);
		return this;
	}

	public String elementSearchInTable() {
		String actualResult = tableElement.getText();
		return actualResult;
		// String expectedText = "Toys";

		/*
		 * if (actualResult.contains(expectedText)) {
		 * System.out.println("Text found in the table!"); } else {
		 * System.out.println("Text not found in the table."); }
		 */
	}

	public SubcategoryPage enterSubCategoryOnField() {
		subCategoryField1.sendKeys("mmaaiitthhrri");
		waitutility.waitUntilElementIsVisible(driver, subCategoryField1);
		return this;
	}

	public SubcategoryPage clickSearchButtonOnList() {
		pageutility.clickJavaScriptExecutor(searchButtonOnList, driver);
		return this;
	}

	public SubcategoryPage clickOnActiveStatusButton() {
		pageutility.clickJavaScriptExecutor(activeButton, driver);
		return this;
	}

	public boolean isAlertDisplayed2() {
		return alertmessageOfActiveStatus.isDisplayed();
	}

	public SubcategoryPage clickOnCategoryDropDownofSearch() {

		pageutility.selectDropdownWithVisibleText(categoryDropdownForSearch, "Toys");
		return this;
	}

}
