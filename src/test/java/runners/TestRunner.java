package runners;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions,hooks")

@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@TotalPriceCalculationInSelectedHotel")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,"
		+ "html:target/cucumber-reports/cucumber-report.html," + "json:target/cucumber-reports/cucumber.json,"
		+ "junit:target/cucumber-reports/cucumber.xml")

public class TestRunner {

}