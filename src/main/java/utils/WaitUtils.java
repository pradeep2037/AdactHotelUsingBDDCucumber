package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static WebElement waitForElementVisible(WebDriver driver, By locator) {

		int waitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static WebElement waitForElementClickable(WebDriver driver, By locator) {

		int waitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
