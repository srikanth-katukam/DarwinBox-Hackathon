package factory;

import dataprovider.ConfigurationDataProvider;
import dataprovider.ExcelDataProvider;

public class DataProvider {
	
	public static ConfigurationDataProvider getConfig()
	{
		ConfigurationDataProvider config = new ConfigurationDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider config = new ExcelDataProvider();
		return config;
	}
}
