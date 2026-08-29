package stepdefinitions;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	private LoginPage loginpage;

	@Given("when user is on the Adactin login page")
	public void when_user_is_on_the_adactin_login_page() {
		loginpage = new LoginPage();
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String string) {
		loginpage.enterUsername(string);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String string) {
		loginpage.enterPassword(string);
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		loginpage.clickLogin();
	}

	@Then("user should see {string}")
	public void user_should_see(String expectedResult) {
		String actualTitle = loginpage.getPageTitle();
		if (actualTitle.equalsIgnoreCase(expectedResult)) {

			Assertions.assertEquals(expectedResult, actualTitle);

		} else {
			String errorMessage = loginpage.getLoginErrorMessage();
			Assertions.assertEquals(expectedResult, errorMessage);
		}
	}

}
