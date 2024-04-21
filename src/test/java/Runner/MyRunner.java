package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features= {"src\\test\\resources\\FeatureFiles\\AccountsPage.feature"},
			glue= {"stepDef","hooks"},
			plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/"},
			monochrome = true
)

public class MyRunner {

}
