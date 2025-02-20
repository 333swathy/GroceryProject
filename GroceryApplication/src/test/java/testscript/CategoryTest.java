package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.Loginpage;

public class CategoryTest extends BaseClass {

	Loginpage login;
	HomePage homepage;
	CategoryPage category;

	@Test
	public void verifyUserAddNewCategoryWithValidDetails() throws IOException, AWTException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		category = homepage.clickOnCategory().clickOnNewCategoryButton().enterNameOnCategoryField()
				.clickOnDiscountField().uploadImageOnImageField().clicktopMenuRadioButton().clickLeftMenuRadioButton()
				.clickOnSaveButton();
		boolean expectedResult=category.isAlertDisplayedForNewCategory();
		Assert.assertTrue(expectedResult, Constants. C_verifyAddNewCategorywithValidDetails);
	}

	@Test
	public void verifyUserCanUpdateImage() throws IOException, AWTException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		category = homepage.clickOnCategory().clickOnEditButton().chooseNewImage().clickOnUpdateButton();
		boolean expectedResult = category.isAlertDisplayed();
		Assert.assertTrue(expectedResult, Constants.C_verifyUserCanEditCategoryAndUploadNewImage);
	}

	@Test
	public void verifeUserCanUpdateStatus() throws IOException {
		login = new Loginpage(driver);
		homepage =login.loginUsingExcelData();
		category =homepage.clickOnCategory().clickOnStatusButton();
		boolean expectedResult = category.isAlertDisplayedForStatus();
		Assert.assertTrue(expectedResult, Constants.C_verifyUserUpdateCategoyStatus);
	}

}