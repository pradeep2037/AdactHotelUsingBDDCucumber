package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import utils.ConfigReader;

public class DriverFactory {

    public static WebDriver driver;

    public static void initializeDriver() {

        String browser = ConfigReader.getProperty("browser");

        // First preference: value passed from command line/Jenkins
        String headlessProperty = System.getProperty("headless");

        // If not passed from Jenkins, read from config.properties
        boolean headless = headlessProperty != null
                ? Boolean.parseBoolean(headlessProperty)
                : Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        try {

            switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();

                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            if (!headless) {
                driver.manage().window().maximize();
            }

            int pageLoadTimeOut = Integer.parseInt(
                    ConfigReader.getProperty("pageLoadTimeout")
            );

            driver.manage()
                  .timeouts()
                  .pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));

            System.out.println("=================================");
            System.out.println("Browser       : " + browser);
            System.out.println("Headless Mode : " + headless);
            System.out.println("OS            : " + System.getProperty("os.name"));
            System.out.println("Java Version  : " + System.getProperty("java.version"));
            System.out.println("=================================");

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to initialize WebDriver for browser: " + browser,
                    e
            );
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