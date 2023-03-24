package hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import config.ConfigurationManager;
import pages.AutoWiredPages;
import utils.DataReader;
import utils.DataSource;

public class TestNgHooks extends AutoWiredPages {


	public String dataSheetName;

	@DataProvider(name = "fetchData")
	public Object[][] fetchData()  {
		DataReader dataReader = new DataSource().setDataSource("json");
		return dataReader.readData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		startApp("chrome", ConfigurationManager.configuration().baseUrl());
		setNode();
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}

}
