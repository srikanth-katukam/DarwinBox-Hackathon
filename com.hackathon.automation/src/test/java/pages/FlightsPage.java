package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import WaitImplenatation.Waits;

public class FlightsPage {
	WebDriver driver;
	public FlightsPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	private static final String FLIGHTS ="//li[@class='flightApp']/a[@title='Flights']";
	private static final String NEXT_MONTH ="//div[@id='ui-datepicker-div']/div[@class='monthBlock last']/div/a";
	private static final String BOOK_TICKETS ="//div[@id='ResultContainer_1_1']/section/section/div/form[@id='flightForm']/section/div/div/button";
	
	private static final String MONTH_YEAR_LABEL = "//div[@class='monthBlock first']/div/div/span[text()='%s']/../span[text()='%s']";
	private static final String DATE_NUMBER_VALUE = "//div[@class='monthBlock first']/table[@class='calendar']/tbody/tr/td/a[text()='%s']";
	//%s flight list
	private static final String DEPARTURE_FLIGHTS = "//div[@id='ResultContainer_1_1']/section/section/div/form[@id='flightForm']/section/div/div[@class='colZero leg col12']/nav/ul";
	private static final String DEPARTURE_FLIGHT_LIST = DEPARTURE_FLIGHTS + "/li";
	private static final String SELECT_DEPARTURE_FLIGHT = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th/input";
	private static final String DEPARTURE_TIME = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='depart']";
	private static final String ARRIVAL_TIME = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='arrive']";
	private static final String DURATION_TIME = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='duration']"; //data-pr
	private static final String PRICE = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th/span[@class='INR']";
	private static final String DEPARTURE_AIRLINES = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/td/span";
	private static final String DEPARTURE_AIRLINE_NUMBER = DEPARTURE_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/td/span/span";
	//%s flight list
	private static final String RETURN_FLIGHTS = "//div[@id='ResultContainer_1_1']/section/section/div/form[@id='flightForm']/section/div/div[@class='colZero leg col12 last']/nav/ul";
	private static final String RETURN_FLIGHT_LIST = RETURN_FLIGHTS + "/li";
	private static final String SELECT_RETURN_FLIGHT = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th/input";
	private static final String RETURN_FLIGHT_DEPARTURE_TIME = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='depart']";
	private static final String RETURN_FLIGHT_ARRIVAL_TIME = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='arrive']";
	private static final String RETURN_FLIGHT_DURATION_TIME = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th[@class='duration']";
	private static final String RETURN_FLIGHT_PRICE = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/th/span[@class='INR']"; //data-pr
	private static final String RETURN_AIRLINES = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/td/span";
	private static final String RETURN_AIRLINE_NUMBER = RETURN_FLIGHTS + "/li[%s]/div/label/table/tbody/tr/td/span/span";
	
	private static final String TOTAL_FLIGHT_PRICE = "//form[@id='flightForm']/section/div/div/h2[@class='totalAmount']"; //data-pr
	//Itenary page
	private static final String FLIGHT_START_TIME = "//div[@class='itinerary clearFix onwBlock']/ul/li[@class='start']/time/span[@class='placeTime']/strong";
	private static final String FLIGHT_END_TIME = "//div[@class='itinerary clearFix onwBlock']/ul/li[@class='end']/time/span[@class='placeTime']/strong";
	private static final String FLIGHT_DURATION = "//div[@class='itinerary clearFix onwBlock']/ul/li[@class='details']/abbr";
	private static final String FLIGHT_NAME = "//div[@class='itinerary clearFix onwBlock']/ul/li/div[@class='airlineName']/span[@class='name']";
	private static final String FLIGHT_NUMBER = "//div[@class='itinerary clearFix onwBlock']/ul/li/div[@class='airlineName']/small[@class='flightNumber']";
	
	private static final String RETURNFLIGHT_START_TIME = "//div[@class='itinerary clearFix retBlock']/ul/li[@class='start']/time/span[@class='placeTime']/strong";
	private static final String RETURNFLIGHT_END_TIME = "//div[@class='itinerary clearFix retBlock']/ul/li[@class='end']/time/span[@class='placeTime']/strong";
	private static final String RETURNFLIGHT_DURATION = "//div[@class='itinerary clearFix retBlock']/ul/li[@class='details']/abbr";
	private static final String RETURNFLIGHT_NAME = "//div[@class='itinerary clearFix retBlock']/ul/li/div[@class='airlineName']/span[@class='name']";
	private static final String RETURNFLIGHT_NUMBER = "//div[@class='itinerary clearFix retBlock']/ul/li/div[@class='airlineName']/small[@class='flightNumber']";
	
	String SELECTFLIGHTIST_DEPARTURETIME;
	String SELECTFLIGHTIST_ARRIVALTIME;
	String SELECTFLIGHTIST_DURATION_TIME;
	String SELECTFLIGHTIST_DEPARTURE_AIRLINES;
	String SELECTRETURNFLIGHTIST_DEPARTURETIME;
	String SELECTRETURNFLIGHTIST_ARRIVALTIME;
	String SELECTRETURNFLIGHTIST_DURATIONTIME;
	String SELECTRETURNFLIGHTIST_AIRLINENAME;
	
	@FindBy(id="RoundTrip") WebElement ROUNDTRIP;
	@FindBy(id="FromTag") WebElement FROM_LOCATION;
	@FindBy(id="ToTag") WebElement TO_LOCATION;	
	@FindBy(id="DepartDate") WebElement DEPARTURE_DATE;
	@FindBy(id="ReturnDate") WebElement RETURN_DATE;
	@FindBy(id="Adults") WebElement ADULTS;
	@FindBy(id="Childrens") WebElement CHILDREN;
	@FindBy(id="Infants") WebElement INFANTS;
	@FindBy(id="SearchBtn") WebElement SEARCH_BUTTON;
	@FindBy(linkText="All flights") WebElement ALLFLIGHTS_LINK;
		
	public void clickRoundTrip()
	{
		Waits.waitForAnElement(driver, ROUNDTRIP);
		ROUNDTRIP.click();
	}
	public void fromLocation(String From)
	{
		Waits.waitForAnElement(driver, FROM_LOCATION);
		FROM_LOCATION.sendKeys(From);
	}
	public void toLocation(String To)
	{
		Waits.waitForAnElement(driver, TO_LOCATION);
		TO_LOCATION.sendKeys(To);
	}
	public void departOn(String DepartOn) throws Exception
	{
		System.out.println("Actual String : "+DepartOn);
		@SuppressWarnings("deprecation")
		Date date = new Date(DepartOn);
		SimpleDateFormat TargetFormat = new SimpleDateFormat("MMMM/d/YYYY");
		String Target = TargetFormat.format(date);
		//Month and Year label
		System.out.println("Month and year Label : " +Target);
		//Split the Strings to get the day
		String[] split = Target.split("/");
		String month = split[0];
		String Datenumber = split[1];
		String Year = split[2];
		System.out.println("Date: "+Datenumber);
		System.out.println("month: "+month);
		System.out.println("Year : "+Year);
		//Click on Date 
		Waits.waitForAnElement(driver, DEPARTURE_DATE);
		DEPARTURE_DATE.click();
		
		while(true)
		{
			try{
				System.out.println("Before isDisplayed");
				
				//Pass the parameters in Xpath
				String MonthYearLabel = String.format(MONTH_YEAR_LABEL, month,Year);
				System.out.println(MonthYearLabel);
				driver.findElement(By.xpath(MonthYearLabel)).isDisplayed();
				System.out.println("Displayed");		
				//Pass the parameters in Xpath
				String DateNumberValue = String.format(DATE_NUMBER_VALUE, Datenumber);
				WebElement EleDateNumberValue = driver.findElement(By.xpath(DateNumberValue));
				Waits.waitForAnElement(driver, EleDateNumberValue);
				EleDateNumberValue.click();
				System.out.println("Clicked");
				break;
			}
			catch(Exception e)
			{
				System.out.println("Exception block");
				WebElement EleNextMonth = driver.findElement(By.xpath(NEXT_MONTH));
				Waits.waitForAnElement(driver, EleNextMonth);
				EleNextMonth.click();
				Thread.sleep(5000);
			}
			
		}
	}
	public void returnOn(String ReturnOn) throws Exception
	{
		System.out.println("Actual String : "+ReturnOn);
		@SuppressWarnings("deprecation")
		Date date = new Date(ReturnOn);
		SimpleDateFormat TargetFormat = new SimpleDateFormat("MMMM/d/YYYY");
		String Target = TargetFormat.format(date);
		//Month and Year label
		System.out.println("Month and year Label : " +Target);
		//Split the Strings to get the day
		String[] split = Target.split("/");
		String month = split[0];
		String Datenumber = split[1];
		String Year = split[2];
		System.out.println("Date: "+Datenumber);
		System.out.println("month: "+month);
		System.out.println("Year : "+Year);
		
		//Click on Date 
		Waits.waitForAnElement(driver, DEPARTURE_DATE);
		DEPARTURE_DATE.click();
		
		while(true)
		{
			try{
				System.out.println("Before isDisplayed");
				
				//Pass the parameters in Xpath
				String MonthYearLabel = String.format(MONTH_YEAR_LABEL, month,Year);
				System.out.println(MonthYearLabel);
				driver.findElement(By.xpath(MonthYearLabel)).isDisplayed();
				System.out.println("Displayed");
				
				//Pass the parameters in Xpath
				String DateNumberValue = String.format(DATE_NUMBER_VALUE, Datenumber);
				WebElement EleDateNumberValue = driver.findElement(By.xpath(DateNumberValue));
				Waits.waitForAnElement(driver, EleDateNumberValue);
				EleDateNumberValue.click();
				System.out.println("Clicked");
				break;
			}
			catch(Exception e)
			{
				System.out.println("Exception block");
				WebElement EleNextMonth = driver.findElement(By.xpath(NEXT_MONTH));
				Waits.waitForAnElement(driver, EleNextMonth);
				EleNextMonth.click();
				Thread.sleep(5000);
			}
			
		}
	}
	public void adults(int Adults)
	{
		int index = Adults-1;
		Waits.waitForAnElement(driver, ADULTS);
		Select SelectList = new Select(ADULTS);
		List<WebElement> Elements =SelectList.getOptions();
		Elements.get(index).click();
	}
	public void children(int Children)
	{
		Waits.waitForAnElement(driver, CHILDREN);
		Select SelectList = new Select(CHILDREN);
		List<WebElement> Elements =SelectList.getOptions();
		Elements.get(Children).click();
	}
	public void infants(int Infants)
	{
		Waits.waitForAnElement(driver, INFANTS);
		Select SelectList = new Select(INFANTS);
		List<WebElement> Elements =SelectList.getOptions();
		Elements.get(Infants).click();
	}
	public void search() throws Exception
	{
		Waits.waitForAnElement(driver, SEARCH_BUTTON);
		//SEARCH_BUTTON.click();
		SEARCH_BUTTON.submit();
		Waits.waitForAnElement(driver, ALLFLIGHTS_LINK);
		String AllFlights= ALLFLIGHTS_LINK.getText();
		Assert.assertEquals(AllFlights, "All flights");
	}
	public void selectFlight(int Highest)
	{
		System.out.println("highest: "+Highest);
		String PriceAttribute = "data-pr";
		System.out.println(DEPARTURE_FLIGHT_LIST);
		WebElement FlightList = driver.findElement(By.xpath(DEPARTURE_FLIGHT_LIST));
		Waits.waitForAnElement(driver, FlightList);
		List<WebElement> ele = driver.findElements(By.xpath(DEPARTURE_FLIGHT_LIST));
		int DepartureFlightList = ele.size();
		DepartureFlightList = DepartureFlightList-Highest+1;
		
		String DepartureTime = String.format(DEPARTURE_TIME, DepartureFlightList-1);
		WebElement DT = driver.findElement(By.xpath(DepartureTime));
		Waits.waitForAnElement(driver, DT);
		System.out.println(DT.getText());
		SELECTFLIGHTIST_DEPARTURETIME = DT.getText();
		
		String ArrivalTime = String.format(ARRIVAL_TIME, DepartureFlightList-1);
		WebElement AT = driver.findElement(By.xpath(ArrivalTime));
		Waits.waitForAnElement(driver, AT);
		System.out.println(AT.getText());
		SELECTFLIGHTIST_ARRIVALTIME = AT.getText();
		
		String DurationTime = String.format(DURATION_TIME, DepartureFlightList-1);
		WebElement DTime = driver.findElement(By.xpath(DurationTime));
		Waits.waitForAnElement(driver, DTime);
		System.out.println(DTime.getText());
		SELECTFLIGHTIST_DURATION_TIME = DTime.getText();
		
		String Price = String.format(PRICE, DepartureFlightList-1);
		WebElement ElePrice = driver.findElement(By.xpath(Price));
		Waits.waitForAnElement(driver, ElePrice);
		System.out.println(ElePrice.getAttribute(PriceAttribute));
		
		String SelectFlight = String.format(SELECT_DEPARTURE_FLIGHT, DepartureFlightList-1);
		WebElement SDF = driver.findElement(By.xpath(SelectFlight));
		Waits.waitForAnElement(driver, SDF);
		SDF.click();
		
		String AirlineName = String.format(DEPARTURE_AIRLINES, DepartureFlightList-1);
		WebElement EleDepartureAirlines = driver.findElement(By.xpath(AirlineName));
		Waits.waitForAnElement(driver, EleDepartureAirlines);
		System.out.println(EleDepartureAirlines.getText());
		SELECTFLIGHTIST_DEPARTURE_AIRLINES = EleDepartureAirlines.getText();
	}
	public void selectReturnFlight(int Highest)
	{
		System.out.println("highest: "+Highest);
		String PriceAttribute = "data-pr";
		WebElement RFL = driver.findElement(By.xpath(RETURN_FLIGHT_LIST));
		Waits.waitForAnElement(driver, RFL);
		System.out.println(RETURN_FLIGHT_LIST);
		List<WebElement> ele = driver.findElements(By.xpath(RETURN_FLIGHT_LIST));
		int ArrivalFlightList = ele.size();
		ArrivalFlightList =ArrivalFlightList-Highest+1;
		
		String RFDepartureTime = String.format(RETURN_FLIGHT_DEPARTURE_TIME, ArrivalFlightList-1);
		WebElement RFDT = driver.findElement(By.xpath(RFDepartureTime));
		Waits.waitForAnElement(driver, RFDT);
		System.out.println(RFDT.getText());
		SELECTRETURNFLIGHTIST_DEPARTURETIME = RFDT.getText();
				
		String RFArrivalTime = String.format(RETURN_FLIGHT_ARRIVAL_TIME, ArrivalFlightList-1);
		WebElement RFAT = driver.findElement(By.xpath(RFArrivalTime));
		Waits.waitForAnElement(driver, RFAT);
		System.out.println(RFAT.getText());
		SELECTRETURNFLIGHTIST_ARRIVALTIME = RFAT.getText();
				
		String RFDurationTime = String.format(RETURN_FLIGHT_DURATION_TIME, ArrivalFlightList-1);
		WebElement RFDURT = driver.findElement(By.xpath(RFDurationTime));
		Waits.waitForAnElement(driver, RFDURT);
		System.out.println(RFDURT.getText());
		SELECTRETURNFLIGHTIST_DURATIONTIME = RFDURT.getText();
				
		String RFPrice = String.format(RETURN_FLIGHT_PRICE, ArrivalFlightList-1);
		WebElement RFP = driver.findElement(By.xpath(RFPrice));
		Waits.waitForAnElement(driver, RFP);
		System.out.println(RFP.getAttribute(PriceAttribute));
				
		String SelectFlight = String.format(SELECT_RETURN_FLIGHT, ArrivalFlightList-1);
		WebElement SRF = driver.findElement(By.xpath(SelectFlight));
		Waits.waitForAnElement(driver, SRF);
		SRF.click();
		
		String AirlineName = String.format(RETURN_AIRLINES, ArrivalFlightList-1);
		WebElement RA = driver.findElement(By.xpath(AirlineName));
		Waits.waitForAnElement(driver, RA);
		System.out.println(RA.getText());
		SELECTRETURNFLIGHTIST_AIRLINENAME = RA.getText();
		
	}
	public void getTotalPrice()
	{
		WebElement EleTotalPrice = driver.findElement(By.xpath(TOTAL_FLIGHT_PRICE));
		Waits.waitForAnElement(driver, EleTotalPrice);
		String TotalPrice = EleTotalPrice.getText();
		System.out.println(TotalPrice);
	}
	public void book()
	{
		WebElement EleBookTickets = driver.findElement(By.xpath(BOOK_TICKETS));
		Waits.waitForAnElement(driver, EleBookTickets);
		EleBookTickets.click();
		//EleBookTickets.submit();
		System.out.println("Ticket Booked");
	}
	public  void VerifyItineraryDetails()
	{
		WebElement EleStartTime = driver.findElement(By.xpath(FLIGHT_START_TIME));
		Waits.waitForAnElement(driver, EleStartTime);
		String StartTime = EleStartTime.getText();
		System.out.println("StartTime : "  +StartTime);
		Assert.assertEquals(StartTime,SELECTFLIGHTIST_DEPARTURETIME);
		
		String EndTime = driver.findElement(By.xpath(FLIGHT_END_TIME)).getText();
		System.out.println("EndTime : "  +EndTime);
		Assert.assertEquals(EndTime, SELECTFLIGHTIST_ARRIVALTIME);
		
		String Duration = driver.findElement(By.xpath(FLIGHT_DURATION)).getText();
		System.out.println("Duration : "  +Duration);
		Assert.assertEquals(Duration, SELECTFLIGHTIST_DURATION_TIME);
		
		String FlightName = driver.findElement(By.xpath(FLIGHT_NAME)).getText();
		System.out.println("FlightName : "  +FlightName);
		Assert.assertTrue(SELECTFLIGHTIST_DEPARTURE_AIRLINES.contains(FlightName));
		
		String FlightNumber = driver.findElement(By.xpath(FLIGHT_NUMBER)).getText();
		System.out.println("FlightNumber : "  +FlightNumber);
		Assert.assertTrue(SELECTFLIGHTIST_DEPARTURE_AIRLINES.contains(FlightNumber));
		
		String RFStartTime = driver.findElement(By.xpath(RETURNFLIGHT_START_TIME)).getText();
		System.out.println("RFStartTime : "  +RFStartTime);
		Assert.assertEquals(RFStartTime, SELECTRETURNFLIGHTIST_DEPARTURETIME);
		
		String RFEndTime = driver.findElement(By.xpath(RETURNFLIGHT_END_TIME)).getText();
		System.out.println("RFEndTime : "  +RFEndTime);
		Assert.assertEquals(RFEndTime, SELECTRETURNFLIGHTIST_ARRIVALTIME);
		
		String RFDuration = driver.findElement(By.xpath(RETURNFLIGHT_DURATION)).getText();
		System.out.println("RFDuration : "  +RFDuration);
		Assert.assertEquals(RFDuration, SELECTRETURNFLIGHTIST_DURATIONTIME);
		
		String RFFlightName = driver.findElement(By.xpath(RETURNFLIGHT_NAME)).getText();
		System.out.println("RFDuration : "  +RFFlightName);
		Assert.assertTrue(SELECTRETURNFLIGHTIST_AIRLINENAME.contains(RFFlightName));
		
		String RFFlightNumber = driver.findElement(By.xpath(RETURNFLIGHT_NUMBER)).getText();
		System.out.println("RFFlightNumber : "  +RFFlightNumber);
		Assert.assertTrue(SELECTRETURNFLIGHTIST_AIRLINENAME.contains(RFFlightNumber));
	}
	

	}
	
