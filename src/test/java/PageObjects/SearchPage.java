package PageObjects;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver ldriver;

	public SearchPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//button/i[@class=\"fas fa-search\"]")
	WebElement searchButton;

	public void clickonSearchButton() {
		searchButton.click();

	}

	@FindBy(id = "SearchEmail")
	WebElement emailTextField;

	public void enterDataIntoEmailTextField(String email) {
		emailTextField.sendKeys(email);

	}

	@FindBy(id = "SearchFirstName")
	WebElement firstNameTextField;

	public void enterDataIntoFirstNameTextField(String fname) {
		firstNameTextField.sendKeys(fname);

	}

	@FindBy(id = "SearchLastName")
	WebElement lastNameTextField;

	public void enterDataIntoLastNameTextField(String lname) {
		lastNameTextField.sendKeys(lname);

	}

	@FindBy(id = "SearchCompany")
	WebElement companyTextField;

	public void enterDataIntoCompanyNameTextField(String cname) {
		companyTextField.sendKeys(cname);

	}

	@FindBy(xpath = "(//tr/td[2])[1]")
	WebElement getFirstPopulatedEmail;

	public String getFirstPopulatedEmail() {

		return getFirstPopulatedEmail.getText();

	}

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> noOfListedRows;

	public int getnoOfListedRows() {

		return noOfListedRows.size();

	}

}
