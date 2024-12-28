package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
		glue = { "com.roadreadywheels.stepDefinations" },
				plugin = { "pretty", 
				           "json:target/cucumber-json-reports/Cucumber.json", 
				           "html:target/cucumber-html-reports/cucumber.html",
				           "junit:target/cucumber-xml-reports/Cucumber.xml" },

				tags = "@splash or @login or @dashboard1"
 
)
public class CucumberRunnerTest {

	//or @dashboard2 or @Paymentdashboard or @amazonpayment

}
