package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports(); //The extentReports instance is shared across the application (static) and cannot be reassigned (final).
	                                                                        //Purpose → This object will store all the logs and details of the test execution.


	public synchronized static ExtentReports createExtentReports() //synchronized → Ensures thread safety when multiple tests run in parallel.
	                                                                //static → Allows calling this method without creating an object.
	                                                                //Returns → An ExtentReports instance.
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //Creates an ExtentSparkReporter instance to generate an HTML report.
		                                                                                               //The report is saved in the extent-reports folder with the file name extent-report.html.
		reporter.config().setReportName("GroceryApplication"); //the name of the report that appears in the generated HTML file.
		extentReports.attachReporter(reporter);// to attach the extends path configuration
		extentReports.setSystemInfo("Organization", "Obsqura"); // to give system level information
		extentReports.setSystemInfo("Name", "Swathy");
		return extentReports;//This method is called in the Listeners class to generate the report.
	}

}
