package hooks;

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
				ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), scenario.getName());

			}
		} finally {

			DriverFactory.quitDriver();
		}
	}
}
