package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			//ConfigurationDataProvider conf = new ConfigurationDataProvider();
			System.setProperty("webdriver.chrome.driver", DataProvider.getConfig().chromePath());
			driver = new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("ie"))
		{
			//ConfigurationDataProvider conf = new ConfigurationDataProvider();
			System.setProperty("webdriver.ie.driver", DataProvider.getConfig().iePath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void closeDriver(WebDriver ldriver)
	{
		ldriver.quit();
	}

}
