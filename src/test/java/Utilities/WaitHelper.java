package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public WebDriver driver;

	public WaitHelper(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// CALL THIS METHOD WHEREVER IT REQUIRES
	public void WaitForElement(WebElement element, long timeOutSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
