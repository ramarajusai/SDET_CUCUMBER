package StepDefinitons;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import Utilities.ReadConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseClass {

	public WebDriver driver;

	public LoginPage lp;
	public SearchPage sp;

	public AddCustomerPage ac;
	public static Logger logger;
	ReadConfig rc = new ReadConfig();

	public String url = rc.getApplicationUrl();
	public String chromePath = rc.getChromePath();
	public String browserValue = rc.getBrowserValue();

	// TO GENERATE MULTIPLE EMAIL ID'S
	public static String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString + "@gmail.com");
	}

}
