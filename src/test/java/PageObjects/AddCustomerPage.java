package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class=\"content-header\"]/h1")
	WebElement dashboard;

	@FindBy(xpath = "//ul[@class=\"nav nav-pills nav-sidebar flex-column nav-legacy\"]/li[4]")
	WebElement customersTab;

	@FindBy(xpath = "//p[text()=' Customers']")
	WebElement customersMenu;

	@FindBy(xpath = "//i[@class=\"fas fa-plus-square\"]")
	WebElement addButton;

	@FindBy(id = "Email")
	WebElement emailField;

	@FindBy(id = "Password")
	WebElement passwordField;

	@FindBy(id = "FirstName")
	WebElement firstNameField;

	@FindBy(id = "LastName")
	WebElement lastNameField;

	@FindBy(xpath = "//div[@class=\"raw\"]/div[1]/input")
	WebElement maleGender;

	@FindBy(xpath = "//div[@class=\"raw\"]/div[2]/input")
	WebElement femaleGender;

	@FindBy(id = "DateOfBirth")
	WebElement dob;

	@FindBy(id = "Company")
	WebElement company;

	@FindBy(xpath = "//button[@name=\"save\"]")
	WebElement saveButton;

	@FindBy(id = "customer-cards")
	WebElement addCustomersPage;

	public void clickOnAddCustomerTab() {
		customersTab.click();

	}

	public void clickOnCustomersMenu() {
		customersMenu.click();

	}

	public void clickOnAddCustomerButton() {
		addButton.click();

	}

	public void enterDataIntoEmailField(String email) {

		WaitHelper wh = new WaitHelper(ldriver);
		wh.WaitForElement(emailField, 3000);
		emailField.sendKeys(email);

	}

	public void enterDataIntoPasswordField(String password) {
		passwordField.sendKeys(password);

	}

	public void enterDataIntoFirstNameField(String fname) {
		firstNameField.sendKeys(fname);

	}

	public void enterDataIntoLastNameField(String lname) {
		lastNameField.sendKeys(lname);

	}

	public void enterDataIntoCompanyName(String cname) {
		company.sendKeys(cname);

	}

	public void selectMaleGender() {

		maleGender.click();

	}

	public void enterDOB(String dateOfBirth) {
		dob.sendKeys(dateOfBirth);

	}

	public void clickOnSaveButton() {
		saveButton.click();

	}

	public boolean isDashboardDisplayed() {

		return dashboard.isDisplayed();
	}

	public boolean isAddCustomersPageDisplayed() {

		return addCustomersPage.isDisplayed();
	}

}
