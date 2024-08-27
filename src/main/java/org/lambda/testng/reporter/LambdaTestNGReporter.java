package org.lambda.testng.reporter;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class LambdaTestNGReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuiteList, List<ISuite> iSuiteList, String s) {

        // generate the report and update the caller from here
        System.out.println("LambdaTestNGReporter :: " + s);
        System.out.println("LambdaTestNGReporter :: " + iSuiteList);
        System.out.println("LambdaTestNGReporter :: " + xmlSuiteList);

        //Iterating over each suite included in the test
        for (ISuite suite : iSuiteList) {

            //Following code gets the suite name
            String suiteName = suite.getName();

            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());
                System.out.println("Name of test "+tc.getName());
            }
        }
    }
}