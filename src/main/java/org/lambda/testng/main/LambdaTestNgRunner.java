package org.lambda.testng.main;

import org.lambda.testng.common.PropertyInitializer;
import org.lambda.testng.common.TestRequest;
import org.lambda.testng.listener.LambdaITestNGListener;
import org.lambda.testng.reporter.LambdaTestNGReporter;
import org.testng.TestNG;

import java.util.List;

public class LambdaTestNgRunner {

    public static String runTest(TestRequest request) {
        try {
            PropertyInitializer.setSystemProperties(request.getEnvironment());
            Class<?> aClass = Class.forName(request.getClassName());

            TestNG testNG = new TestNG();
            testNG.setUseDefaultListeners(false);
            testNG.setDefaultTestName(request.getUuid());
            testNG.setTestClasses(new Class[]{aClass});
            testNG.setListenerClasses(List.of(LambdaTestNGReporter.class,LambdaITestNGListener.class));
            testNG.run();

            return "SUCCESS";

        } catch (ClassNotFoundException  exception) {
            return "FAILURE" + exception.getMessage();
        }
    }


}


