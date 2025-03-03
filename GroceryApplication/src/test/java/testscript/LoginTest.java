package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.Loginpage;

public class LoginTest extends BaseClass {
	@Test(groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		Loginpage login = new Loginpage(driver);
		login.loginUsingExcelData();
		boolean expectedResult = true;
		boolean actualResult = login.isHomePageLoaded();
		Assert.assertEquals(actualResult, expectedResult, Constants.lp_verifyLoginWithValidCredentials);
	}

	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() {
		Loginpage login = new Loginpage(driver);
		String username = "swathy";
		String password = "admin";
		login.enterUsernameOnUernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean actualResult = login.getAlertMessage();
		Assert.assertTrue(actualResult, Constants.lp_verifyLoginWithInValidCredentials);
	}

	@Test(dataProvider = "dataprovider1")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword(String username, String password) {
		Loginpage login = new Loginpage(driver);
		login.enterUsernameOnUernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean actualReult = login.getAlertMessage();
		Assert.assertTrue(actualReult, Constants.lp_verifyLoginWithInValidCredentials);
	}

	@DataProvider(name = "dataprovider1")
	public Object[][] dpmethod1() {
		return new Object[][] { { "abcf", "223" }, { "bsh", "333" }, { "shgjgh", "333" }, { "gsvgh", "555" } };
	}

	@Test(groups = "smoke")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword() {
		Loginpage login = new Loginpage(driver);
		String username = "swathy";
		String password = "123";
		login.enterUsernameOnUernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean actualResult = login.getAlertMessage();
		Assert.assertTrue(actualResult, Constants.lp_verifyLoginWithInValidCredentials);
	}
}
