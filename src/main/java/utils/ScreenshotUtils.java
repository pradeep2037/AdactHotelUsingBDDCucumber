package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String scenarioName) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String safeScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9._-]", "_");

			File destination = new File("target/screenshots/" + safeScenarioName + ".png");

			destination.getParentFile().mkdirs();

			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {

			throw new RuntimeException("Unable to save screenshot for: " + scenarioName, e);
		}
	}
}