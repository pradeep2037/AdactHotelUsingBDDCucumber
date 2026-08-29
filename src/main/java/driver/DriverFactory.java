package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {

	public static WebDriver driver;

	public static void initializeDriver() {

		String browser = ConfigReader.getProperty("browser");

		try {

			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				throw new RuntimeException("Unsupported browser: " + browser);
			}

			driver.manage().window().maximize();
			int pageLoadTimeOut = Integer.parseInt(ConfigReader.getProperty("pageLoadTimeout"));

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));

		} catch (Exception e) {
			throw new RuntimeException("Unable to initialize WebDriver for browser: " + browser, e);
		}

	}

	public static WebDriver getDriver() {

		if (driver == null) {
			throw new RuntimeException("WebDriver is not initialized");
		}

		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
