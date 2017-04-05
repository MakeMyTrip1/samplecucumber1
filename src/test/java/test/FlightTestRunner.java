package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="BookFlight",glue={"flightBookingStepDefinition"},plugin={"html:HTML_Report/FlightStatusReport","junit:XML_Report/FlightStatusReport.xml"},format = { "pretty"})

public class FlightTestRunner {

}
