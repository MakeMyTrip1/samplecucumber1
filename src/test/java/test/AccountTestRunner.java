package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="AccountFeature",glue={"accountStepDefinition"},plugin={"html:HTML_Report/AccountStatusReport","junit:XML_Report/AccountStatusReport.xml"},format = { "pretty"})

public class AccountTestRunner {

}
