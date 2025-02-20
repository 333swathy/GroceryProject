package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class ManageProductsPage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtilities waitutility = new WaitUtilities();
	FileUploadUtility fileupload=new FileUploadUtility();

	public ManageProductsPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newManageProductButton;
	@FindBy(xpath = "//input[@name='title']")
	WebElement titleField;
	@FindBy(xpath = "//input[@value='Others']")
	WebElement productTypeRadiobutton;
	@FindBy(xpath = "//input[@id='tag']")
	WebElement tagField;
	@FindBy(xpath = "//select[@class='form-control selectpicker'and @name='cat_id']")
	WebElement categoryField;
	@FindBy(xpath = "//select[@class='form-control selectpicker'and @name='sub_id']")
	WebElement subcategoryField;
	@FindBy(xpath = "//select[@class='form-control selectpicker'and @name='grp_id']")
	WebElement groupDropdown;
	@FindBy(xpath = "//input[@value='weight']")
	WebElement priceTypeRadioButton;
	@FindBy(xpath = "//input[@id='m_weight']")
	WebElement weightValueFiled;
	@FindBy(xpath = "//select[@id='w_unit']")
	WebElement weightUnitDropDown;
	@FindBy(xpath = "//input[@id='max_weight']")
	WebElement maximumQuantityDropDown;
	@FindBy(xpath = "//input[@name='w_price']")
	WebElement priceFiled;
	@FindBy(xpath = "//input[@name='w_mrp']")
	WebElement mRP_field;
	@FindBy(xpath = "//input[@name='w_stock']")
	WebElement stockAvailabilityField;
	@FindBy(xpath = "//input[@name='w_pp']")
	WebElement purchasePriceFiled;
	@FindBy(xpath = "//input[@name='unlimitw[]']")
	WebElement unlimitedStockCheckBox;
	@FindBy(xpath = "//input[@value='yes' and @name='stock']")
	WebElement stockRadioButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageChooseFileButton;
	@FindBy(xpath = "//input[@id='main_imgs']")
	WebElement subImageChooseFileButton;
	@FindBy(xpath = "//input[@value='no' and @name='featured']")
	WebElement featuredRadioButton;
	@FindBy(xpath = "//input[@value='no' and @name='combo']")
	WebElement comboPackRadioButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss'][1]")WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deleteAlertMessage;
	@FindBy(xpath="//a[@role='button']")List<WebElement>  featureStatusButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement statusAlert;
	
	
	public ManageProductsPage clickOnNewManageProductButton() {
		newManageProductButton.click();
		return this;
	}

	public ManageProductsPage enterProductTitle() {
		titleField.sendKeys("Dry Fruits");
		return this;

	}

	public ManageProductsPage clickOnproductTypeRadiobutton() {
		pageutility.selectRadioButton(productTypeRadiobutton);
		return this;
	}

	public ManageProductsPage enterTagOnTagFiled() {
		tagField.sendKeys("<<Fruits");
		return this;
	}

	public ManageProductsPage selectCategoryDropDown() {
		pageutility.selectDropdownWithVisibleText(categoryField, "select");
		return this;
	}

	public ManageProductsPage selectSubCategoryDropDown() {
		pageutility.selectDropdownWithVisibleText(subcategoryField, "select");
		return this;
	}

	public ManageProductsPage selectGroupDropDown() {
		pageutility.selectDropdownWithVisibleText(groupDropdown, "discount");
		return this;
	}

	public ManageProductsPage selectPriceTypeRadioButton() {
		waitutility.waitUntilElementToBeClickable(driver, priceTypeRadioButton);
		pageutility.selectRadioButton(priceTypeRadioButton);
		return this;

	}

	public ManageProductsPage enterValueOnWeightValue() {
		weightValueFiled.sendKeys("1");
		return this;
	}

	public ManageProductsPage selectWeightUnit() {
		pageutility.selectDropdownWithValue(weightUnitDropDown, "kg");
		return this;
	}

	public ManageProductsPage enterMaximimQuantityCanOrder() {
		maximumQuantityDropDown.sendKeys("5");
		return this;
	}

	public ManageProductsPage enterPriceOnPriceField() {
		priceFiled.sendKeys("1000");
		return this;
	}

	public ManageProductsPage enterMrpOnFiled() {
		mRP_field.sendKeys("1200");
		return this;
	}

	public ManageProductsPage enterStockAvailability() {
		stockAvailabilityField.sendKeys("100");
		return this;
	}

	public ManageProductsPage enterPurchasePriceValue() {
		purchasePriceFiled.sendKeys("800");
		return this;
	}

	public ManageProductsPage selectUnlimitedChechBox() {
		pageutility.selectCheckbox(unlimitedStockCheckBox);
		return this;
	}

	public ManageProductsPage selectStockRaduiButton() {
		waitutility.waitUntilElementToBeClickable(driver, productTypeRadiobutton);
		pageutility.selectRadioButton(productTypeRadiobutton);
		return this;
	}

	public ManageProductsPage uploadImage() {
		String image = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\dryfruits.jpg";
		fileupload.fileuploadusingsendkeys(imageChooseFileButton, image);
		waitutility.waitForImageToBeVisible(driver, imageChooseFileButton);
		return this;
		
	}

	public ManageProductsPage uplaodSubImages() {
		String subimage = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\dryfruits free.jpg";
		fileupload.fileuploadusingsendkeys(subImageChooseFileButton, subimage);
		waitutility.waitForImageToBeVisible(driver, subImageChooseFileButton);
		return this;
	}

	public ManageProductsPage selectFeaturedRadioButton() {
		waitutility.waitUntilElementToBeClickable(driver, featuredRadioButton);
		pageutility.selectRadioButton(featuredRadioButton);
		return this;
	}

	public ManageProductsPage selectComboPackRadioButton() {
		waitutility.waitUntilElementToBeClickable(driver, comboPackRadioButton);
		pageutility.selectRadioButton(comboPackRadioButton);
		return this;
	}

	public ManageProductsPage clickOnSaveButton() {
		waitutility.waitUntilElementToBeClickable(driver, saveButton);
		pageutility.scrollDownAndClick(saveButton);
		pageutility.clickJavaScriptExecutor(saveButton, driver);
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}
	public ManageProductsPage clickDeleteButton()
	{
		pageutility.clickJavaScriptExecutor(deleteButton, driver);
		driver.switchTo().alert().accept();
		return this;
	}
	public boolean isAlertDisplayed2() {
		return deleteAlertMessage.isDisplayed();
	}
	public ManageProductsPage clickOnFeatureButton()
	{
		pageutility.clickJavaScriptExecutor(featureStatusButton.get(0), driver);
		return this;
	}
	public boolean isAlertDisplayed3() {
		return statusAlert.isDisplayed();
	}

}
