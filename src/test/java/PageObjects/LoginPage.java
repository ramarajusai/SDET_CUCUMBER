package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "Password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement btnlogOut;

	public void setUsername(String uname) {
		txtEmail.clear();

		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		btnLogin.click();
	}

	public void clickOnLogoutButton() {
		btnlogOut.click();

	}

}
