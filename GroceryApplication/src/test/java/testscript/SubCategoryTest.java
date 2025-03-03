package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.Loginpage;
import pages.SubcategoryPage;

public class SubCategoryTest extends BaseClass {
	Loginpage login;
	HomePage homepage;
	SubcategoryPage subcategory;

	@Test(groups = { "smoke" })
	public void verifyAddNewSubCategoryWithValidDetails() throws IOException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		subcategory = homepage.clickOnSubCategory().clickOnNewSubCategoryButton().clickOnCategoryDropdown()
				.clickOnSubCategoryField().imageUploadInSubcategory().clickOnSaveButton();
		boolean isAlertPresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.SC_verifyAddNewSubcategorywithValidDetails);

	}

	@Test
	public void verifyUserCanSearchForSubcategory() throws IOException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		subcategory = homepage.clickOnSubCategory().clickOnSearchButton().clickOnCategoryDropDownofSearch()
				.clickOnsearchButtonForSelectDropdown();
		String actualResult = subcategory.elementSearchInTable();
		String expectedResult = "Toys";
		Assert.assertEquals(actualResult, expectedResult, Constants.SC_verifySearchListSubCategories);

	}

	@Test
	public void verifySubCategoryStatusCanChange() throws IOException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		subcategory = homepage.clickOnSubCategory().clickOnSearchButton().clickOnCategoryDropDownofSearch()
				.clickOnsearchButtonForSelectDropdown().clickOnActiveStatusButton();
		boolean isAlertPresent = subcategory.isAlertDisplayed2();
		Assert.assertTrue(isAlertPresent, Constants.SC_verifyUserCanUpdateTheSubcategoryStatus);
	}// .enterSubCategoryOnField()
}
