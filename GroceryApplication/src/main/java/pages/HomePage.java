package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class=' nav-link' ]")
	WebElement subcategory;
	@FindBy(xpath = "//p[text()='swd']//following::p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\" and @class='small-box-footer']")
	WebElement adminUserMoreInfoFooter;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement category;

	public SubcategoryPage clickOnSubCategory() {
		subcategory.click();
		return new SubcategoryPage(driver);
	}

	public ManageProductsPage clickOnManageProduct() {
		manageProduct.click();
		return new ManageProductsPage(driver);
	}

	public AdminUserPage clickOnAdminUserMoreInfoFooter() {
		pageutility.clickJavaScriptExecutor(adminUserMoreInfoFooter, driver);
		return new AdminUserPage(driver);
	}

	public CategoryPage clickOnCategory() {
		category.click();
		return new CategoryPage(driver);
	}
}