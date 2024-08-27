//package org.lambda.test;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import org.testng.TestNG;
//
//import java.util.Map;
//
//public class LambdaRunner implements RequestHandler<Map<String, String>, Object> {
//    @Override
//    public Object handleRequest(Map<String, String> input, Context context) {
//        try {
//            System.setProperty("environment.id", "INFRA");
//            System.setProperty("environment.hostname", "");
//            System.setProperty("environment.chrome.version", "116");
//            System.setProperty("environment.chrome.headless", "true");
//            System.setProperty("environment.rerun.count", "0");
//            System.setProperty("environment.pod.name", "");
//
//            String classpath = System.getProperty("java.class.path");
//            System.out.println(classpath);
//
//            Class<?> aClass = Class.forName(input.get("class"));
//            TestNG testNG = new TestNG();
//            testNG.setTestClasses(new Class[]{aClass});
//            testNG.run();
//            return "SUCCESS";
//        } catch (ClassNotFoundException classNotFoundException) {
//            return "FAILURE" + classNotFoundException.getMessage();
//        }
//    }
//}
