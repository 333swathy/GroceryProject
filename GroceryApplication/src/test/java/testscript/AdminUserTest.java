package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.PageUtility;
import utilities.WaitUtilities;

public class AdminUserTest extends BaseClass {
	Loginpage login;
	HomePage homepage;
	AdminUserPage adminuser;

	@Test
	public void verifyIfNewUserInfoCanAdd() throws IOException {
		login = new Loginpage(driver);
		homepage=login.loginUsingExcelData();
		adminuser=homepage.clickOnAdminUserMoreInfoFooter().clickOnnewAdminUserButton().enterNewUsernameOnField()
				.enterNewPasswordOnField().chooseTypeFromTypeDropdown().clickOnSaveButton();
		boolean isAlertPresent=adminuser.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.AU_verifyAddNewAdminUserwithValidDetails);
	

	}
	@Test
	public void verifyIfUserInfoCanDelete() throws IOException
	{
		login = new Loginpage(driver);
		homepage=login.loginUsingExcelData();
		adminuser=homepage.clickOnAdminUserMoreInfoFooter().clickDeleteButtonOfUserList();
		//driver.switchTo().alert().accept();
		boolean isAlertPresent=adminuser.isAlertDisplayed2();
		Assert.assertTrue(isAlertPresent, Constants.AU_verifyUserCanDeletAdminUser);
	}
	@Test
	public void verifyIfUserInfoCanEdit() throws IOException
	{
		login = new Loginpage(driver);
		homepage=login.loginUsingExcelData();
	    adminuser=homepage.clickOnAdminUserMoreInfoFooter().clickOnEditButton().enterNewUsernameOnField()
	    		.enterNewPasswordOnField().clickOnUpdateButton();
		boolean isAlertPresent=adminuser.isAlertDisplayed3();
		Assert.assertTrue(isAlertPresent,Constants.AU_verifyUserCanEditAndUpdateUserDetails);
	}
	@Test
	public void verifyIfUserInfoCanUpdateStatus() throws IOException
	{
		login = new Loginpage(driver);
		homepage=login.loginUsingExcelData();
		adminuser=homepage.clickOnAdminUserMoreInfoFooter().clickOnStatusFirstSuccessButton();
		adminuser.clickOnStatusFirstSuccessButton();
		boolean isAlertPresent=adminuser.isAlertDisplayed4();
		Assert.assertTrue(isAlertPresent,Constants.AU_verifyUserUpdateStausOfUserDetails);
	}
}
	
		
		
		
		
