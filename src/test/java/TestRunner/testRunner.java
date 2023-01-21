package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//dry run--> it will crosscheck if respective feature contains step definition or not and in output chrome will not be opened the methods to the res feature will be displayed
// monochrome ----> to get clear cut output in console window
@CucumberOptions(features = "C://Users//DELL//eclipse-workspace//SDET_CUCUMBER_FRAMEWORK//Features//Login.feature", glue = "StepDefinitons",dryRun=false, monochrome=true,plugin= {"pretty","html:test-output"},tags= {"@Smoke"})
public class testRunner {

	
	
}
