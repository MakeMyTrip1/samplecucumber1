package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="AccountFeature",glue={"accountStepDefinition"},tags="@Signup")

public class AccountTestRunner {

}
