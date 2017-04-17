package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="BookHotel",glue={"hotelStepDefinition"},plugin={"html:HTML_Report/HotelStatusReport","junit:XML_Report/HotelStatusReport.xml"},format = { "pretty"})

public class HotelTestRunner {

}
