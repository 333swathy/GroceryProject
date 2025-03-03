package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.Loginpage;
import pages.ManageProductsPage;

public class ManageProductTest extends BaseClass {
	Loginpage login;
	HomePage homepage;
	ManageProductsPage manageproduct;

	@Test
	public void verifyIfUserCanAddNewManagrProductWithoutMandatoryFields() throws IOException, AWTException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();

		manageproduct = homepage.clickOnManageProduct().clickOnNewManageProductButton().enterProductTitle()
				.clickOnproductTypeRadiobutton().enterTagOnTagFiled().selectGroupDropDown().selectPriceTypeRadioButton()
				.enterValueOnWeightValue().selectWeightUnit().enterMaximimQuantityCanOrder().enterPriceOnPriceField()
				.enterMrpOnFiled().enterStockAvailability().enterPurchasePriceValue().selectUnlimitedChechBox()
				.selectStockRaduiButton().uploadImage().uplaodSubImages().selectFeaturedRadioButton()
				.selectComboPackRadioButton().clickOnSaveButton();
		boolean isAlertPresent = manageproduct.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.MP_verifyAddNewCategorywithoutMandatoryFields);
	}

	@Test
	public void verifyUserCanDeleteProductDetails() throws IOException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		manageproduct = homepage.clickOnManageProduct().clickDeleteButton();
		boolean isAlertPresent = manageproduct.isAlertDisplayed2();
		Assert.assertTrue(isAlertPresent, Constants.MP_verifyUserCanDeletProductDetails);

	}

	@Test
	public void verifyUserCanUpdateStatusOfProductDetails() throws IOException {
		login = new Loginpage(driver);
		homepage = login.loginUsingExcelData();
		manageproduct = homepage.clickOnManageProduct().clickOnFeatureButton();
		boolean isAlertPresent = manageproduct.isAlertDisplayed3();
		Assert.assertTrue(isAlertPresent, Constants.Mp_verifyUserUpdateProductDetailsStatus);

	}
}
