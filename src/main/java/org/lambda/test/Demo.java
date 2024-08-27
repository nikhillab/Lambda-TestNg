package org.lambda.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.CucumberRerunSuiteListener;
import testng.FastFailListener;

@CucumberOptions(
        dryRun = false,
        plugin = {"pretty", "json:target/cucumber-report.json","framework.cucumber.TestTrackerPlugin", "cucumber.formatting.CucumberFormatter", "rerun:target/rerunFiles/AAAALoginServiceTestRunnerFailures.txt", "selenium.driver.BrowserUtil"},
        tags = "",
        features = {"classpath:Features/QA/Automation/AAAALoginServiceTest.feature"},
        glue = {"demo.framework"}
)
@Listeners({FastFailListener.class, CucumberRerunSuiteListener.class, FastFailListener.class})
public class Demo extends AbstractTestNGCucumberTests {
    public Demo() {
    }

    @Test(
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios",
            timeOut = 0L
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        FastFailListener.testForAbortCondition();
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
