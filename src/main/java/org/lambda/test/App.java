package org.lambda.test;

import org.lambda.testng.listener.LambdaITestNGListener;
import org.lambda.testng.reporter.LambdaTestNGReporter;
import org.testng.TestNG;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        runTest();
    }

    public static String runTest() {

        System.setProperty("environment.chrome.version", "116");

        System.setProperty("CONFIG.BASEPATH", "environment/");
        System.setProperty("environment.chrome.headless", "true");
        System.setProperty("environment.rerun.count", "0");
        System.setProperty("environment.id", "local");
        System.setProperty("environment.hostname", "demo.com");
        System.setProperty("environment.chrome.headless","true");

        try {
            Class<?> aClass = Class.forName("org.lambda.test.Demo");
            TestNG testNG = new TestNG();
            testNG.setUseDefaultListeners(false);
            testNG.setDefaultTestName(UUID.randomUUID().toString());
            testNG.setTestClasses(new Class[]{aClass});
            testNG.setListenerClasses(List.of(LambdaTestNGReporter.class,LambdaITestNGListener.class));
            testNG.run();
        } catch (ClassNotFoundException e) {
            return "FAILED :" + e.getMessage();
        }
        return "SUCCESS";
    }
}
/**
 * Runner generation logic change
 * Logic to launch chrome in lambda (zip/container)
 * Implement the same in lambda handler
 * remove guava from dep as it's causing issue
 * <p>
 * <p>
 */


