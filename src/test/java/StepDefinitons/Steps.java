package StepDefinitons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import Utilities.WaitHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.*;

public class Steps extends BaseClass {

	public String fname = "anirudh";
	public String lname = "sai";
	public String company = "rockstar";
	public String email = "anirudh1989@gmail.com";

	@Before
	// SINCE THIS IS THE CUCUMBER ANNOTATION WE CAN NOT KEEP THIS IN BASE CLASS AND
	// USE HERE USING EXTENDS KEYWORD
	public void user_launches_Chrome_browser() {

		logger = Logger.getLogger("nop_ecommerce"); // ADDED LOGGER
		PropertyConfigurator.configure("log4j.properties"); // GIVE THE CONFIG PROPFILE NAME OR LOCATION
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		logger.info("LAUNCHING THE URL");
		// LOG THE STATEMENTS ON CONSOLE driver.manage().window().maximize();

		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		ac = new AddCustomerPage(driver);
		sp = new SearchPage(driver);

		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@After
	// @Then("Close Browser")
	public void close_Browser() {
		driver.close();
	}

	@When("User opens url {string}")
	public void user_opens_url(String string) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String string, String string2) {
		lp.setUsername(string);
		lp.setPassword(string2);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickOnLoginButton();
		Thread.sleep(5000);
	}

	@Then("Home Page title should be {string}")
	public void page_title_should_be(String string) {

		assertEquals(string, driver.getTitle());
		System.out.println("*********************************" + driver.getTitle());
	}

	@When("User click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		lp.clickOnLogoutButton();
		Thread.sleep(5000);
	}

	@Then("Login Page tilte should be {string}")
	public void page_tilte_should_be(String string) {
		System.out.println("*********************************" + driver.getTitle());
		assertEquals(driver.getTitle(), string);
	}

	/////////////////////////////////////// ****************************************************************?????????????????????????????????????????///////////////

	@Then("User can view dashboard")
	public void user_can_view_dashboard() {

		assertEquals(ac.isDashboardDisplayed(), true);
	}

	@When("User click on Customers menu")
	public void user_click_on_Customers_menu() {
		ac.clickOnAddCustomerTab();

	}

	@When("Click on Customers menu item")
	public void click_on_Customers_menu_item() {

		ac.clickOnCustomersMenu();
	}

	@When("Click on Add new button")
	public void click_on_Add_new_button() {

		ac.clickOnAddCustomerButton();

	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {

		assertEquals(ac.isAddCustomersPageDisplayed(), true);
	}

	@When("User enter Customer info")
	public void user_enter_Customer_info() {

		// ac.enterDataIntoEmailField(randomString());
		ac.enterDataIntoEmailField(email);
		ac.enterDataIntoPasswordField("test123");
		ac.enterDOB("10/23/1996");
		ac.enterDataIntoFirstNameField(fname);
		ac.enterDataIntoLastNameField(lname);
		ac.enterDataIntoCompanyName(company);

	}

	@When("Click on Save button")
	public void click_on_Save_button() {

		ac.clickOnSaveButton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {

		assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}

	@When("User enter data into Email text field")
	public void user_enter_data_into_Email_text_field() throws InterruptedException {
		Thread.sleep(2000);
		sp.enterDataIntoEmailTextField(email);
		Thread.sleep(2000);
		sp.clickonSearchButton();
		Thread.sleep(1000);

	}

	@Then("records should be filtered with sorted email")
	public void records_should_be_filtered_with_sorted_email() {
		// CHECK IF THERE IS ONLY ONE RECORD IN DATA

		if (sp.getnoOfListedRows() == 1) {

			// now validate the exact match of email is displayed

			sp.getFirstPopulatedEmail();
			assertEquals(sp.getFirstPopulatedEmail(), email);

		}

		else {

			assertTrue(false);
			System.out.println(
					"******************MOTRE THAN ONE RECORD IS FOUND FOR THE SEARCHED EMAIL***********************************");
		}

	}

}
