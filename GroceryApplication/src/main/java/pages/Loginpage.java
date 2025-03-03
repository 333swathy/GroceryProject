package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class Loginpage {
	public WebDriver driver;

	public Loginpage(WebDriver driver)// constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// driver.:initialisation
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement loginbutton;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;

	public void enterUsernameOnUernameField(String username) {
		usernamefield.sendKeys(username);

	}

	public void enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public HomePage loginUsingExcelData() throws IOException {
		String username = ExcelUtility.readStringDataFromExcel(1, 0, "Loginpage");
		usernamefield.sendKeys(username);
		String password = ExcelUtility.readStringDataFromExcel(1, 1, "Loginpage");
		passwordfield.sendKeys(password);
		loginbutton.click();
		return new HomePage(driver);
	}

	public HomePage clickOnLoginButton() {
		loginbutton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageLoaded() {
		return homepage.isDisplayed();

	}

	public boolean getAlertMessage() {
		return alertmessage.isDisplayed();
	}

}
