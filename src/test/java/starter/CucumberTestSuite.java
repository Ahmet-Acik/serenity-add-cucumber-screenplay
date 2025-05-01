package starter;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

// This class configures and runs the Cucumber test suite using JUnit Platform
@Suite
// Specifies that the Cucumber engine should be used to execute the tests
@IncludeEngines("cucumber")
// Specifies the location of the feature files in the classpath
@SelectClasspathResource("/features")
// Configures the Cucumber plugin to use Serenity reporting, pretty output, and a timeline report
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline"
)
public class CucumberTestSuite {
    // This class serves as an entry point for running Cucumber tests with the specified configuration
}