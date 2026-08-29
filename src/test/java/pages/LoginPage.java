package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import utils.WaitUtils;

public class LoginPage {

	private final WebDriver driver;

	public LoginPage() {

		driver = DriverFactory.getDriver();
	}

	// Locators
	private final By username = By.id("username");
	private final By password = By.id("password");
	private final By loginButton = By.id("login");

	// Invalid login error message
	private final By loginErrorMessage = By.xpath("//b[contains(text(),'Invalid Login')]");

	public void enterUsername(String userName) {

		WaitUtils.waitForElementVisible(driver, username).sendKeys(userName);
	}

	public void enterPassword(String passWord) {

		WaitUtils.waitForElementVisible(driver, password).sendKeys(passWord);
	}

	public void clickLogin() {

		WaitUtils.waitForElementClickable(driver, loginButton).click();
	}

	public void login(String userName, String passWord) {

		enterUsername(userName);
		enterPassword(passWord);
		clickLogin();
	}

	public String getLoginErrorMessage() {

		return WaitUtils.waitForElementVisible(driver, loginErrorMessage).getText();
	}

	public String getPageTitle() {

		return driver.getTitle();
	}
}