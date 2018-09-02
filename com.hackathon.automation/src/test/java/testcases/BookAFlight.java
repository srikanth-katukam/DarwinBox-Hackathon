package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.BrowserFactory;
import factory.DataProvider;
import pages.FlightsPage;
import utility.PageScreenshot;

public class BookAFlight {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setUp()
	{
		report = new ExtentReports(".\\Reports\\LoginReport.html", true);
		logger = report.startTest("Book a Rountrip Ticket");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Browser instantiated");
		driver.get(DataProvider.getConfig().applicationURL());
		logger.log(LogStatus.INFO, "Navigated to URL");
		PageScreenshot.takeScreenshot(driver);
	}
	@Test
	public void bookForRoundTrip() throws Exception
	{
		logger.log(LogStatus.INFO, "Inherit Flights page");
		FlightsPage flights = PageFactory.initElements(driver, FlightsPage.class);
		flights.clickRoundTrip();
		logger.log(LogStatus.PASS, "Checked Roundtrip radio button");
		PageScreenshot.takeScreenshot(driver);
		flights.fromLocation(DataProvider.getExcel().getData(0, 2, 0));
		logger.log(LogStatus.PASS, "From location selected successfully");
		flights.toLocation(DataProvider.getExcel().getData(0, 2, 1));
		logger.log(LogStatus.PASS, "To location selected successfully");
		flights.departOn(DataProvider.getExcel().getData(0, 2, 2));
		logger.log(LogStatus.PASS, "Selected date successfully");
		flights.returnOn(DataProvider.getExcel().getData(0, 2, 3));
		logger.log(LogStatus.PASS, "Selected Return date successfully");
		PageScreenshot.takeScreenshot(driver);
		flights.adults(DataProvider.getExcel().getIntData(0, 3, 4));
		logger.log(LogStatus.PASS, "Selected Adults tickets successfully");
		flights.children(DataProvider.getExcel().getIntData(0, 4, 5));
		logger.log(LogStatus.PASS, "Selected Children tickets successfully");
		flights.search();
		logger.log(LogStatus.PASS, "Search Successfull");
		flights.selectFlight(DataProvider.getExcel().getIntData(0, 1, 7));
		PageScreenshot.takeScreenshot(driver);
		logger.log(LogStatus.PASS, "Selected flight successfully");
		flights.selectReturnFlight(DataProvider.getExcel().getIntData(0, 1, 8));
		logger.log(LogStatus.PASS, "Selected Return flight successfully");
		PageScreenshot.takeScreenshot(driver);
		flights.getTotalPrice();
		flights.book();
		flights.VerifyItineraryDetails();
		PageScreenshot.takeScreenshot(driver);
		logger.log(LogStatus.PASS, "Successfully booked RoundTrip");
		logger.log(LogStatus.INFO, "Verified ItineraryDetails");
	}	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeDriver(driver);
		logger.log(LogStatus.PASS, "Broswer instance closed successfully");
		report.endTest(logger);
		report.flush();
	}
}
