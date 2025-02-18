package constants;

public class Constants {
	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String lp_verifyLoginWithValidCredentials="login Failed for valid credantials..";
	public static final String lp_verifyLoginWithInValidCredentials="Alert message is not as expected";
	public static final String AU_verifyAddNewAdminUserwithValidDetails = "Subcategory is not added ";
	public static final String AU_verifyUserCanDeletAdminUser = "AdminUser Details not deleted as expected";
	public static final String AU_verifyUserCanEditAndUpdateUserDetails = "Alert message is not expected";
	public static final String AU_verifyUserUpdateStausOfUserDetails = "Alert is not Displayed";
	public static final String C_verifyAddNewCategorywithValidDetails = "Category is not added ";
	public static final String C_verifyUserCanEditCategoryAndUploadNewImage = "Alert message is not expected";
	public static final String C_verifyUserUpdateCategoyStatus = "Alert is not Displayed";
	public static final String MP_verifyAddNewCategorywithoutMandatoryFields = "New product Added Without Mandatory Field";
	public static final String MP_verifyUserCanDeletProductDetails = "Deleting  not possible";
	public static final String Mp_verifyUserUpdateProductDetailsStatus = "Alert is not Displayed";
	public static final String SC_verifyAddNewSubcategorywithValidDetails = "Subcategory is not added successfully";
	public static final String SC_verifySearchListSubCategories = "Search results are not displayed as expected";
	public static final String SC_verifyUserCanUpdateTheSubcategoryStatus = "Could not change the product status";
	public static final String TEST_DATE_FILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData\\LoginPage.xlsx";
	
}


