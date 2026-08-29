package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import utils.ConfigReader;
import utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void setUp() {

		DriverFactory.initializeDriver();

		WebDriver driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getProperty("url"));
	}

	@After
	public void tearDown(Scenario scenario) {

		try {

			if (scenario.isFailed()) {

				WebDriver driver = DriverFactory.getDriver();

				// Save screenshot as physical file
				ScreenshotUtils.takeScreenshot(driver, scenario.getName());

				// Attach screenshot to Cucumber report
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				scenario.attach(screenshot, "image/png", scenario.getName());
			}

		} finally {

			DriverFactory.quitDriver();
		}
	}
}