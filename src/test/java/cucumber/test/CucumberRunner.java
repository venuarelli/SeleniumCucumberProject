package cucumber.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/cucumbr-html-report"})
public class CucumberRunner {

}
