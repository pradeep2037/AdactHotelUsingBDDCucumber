package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String scenarioName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			File path = new File("target/screenshots/" + scenarioName + ".png");

			path.getParentFile().mkdirs();

			Files.copy(file.toPath(), path.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("Unable to save screenshot for: " + scenarioName, e);
		}

	}

}
