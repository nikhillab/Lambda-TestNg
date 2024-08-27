package org.lambda.testng.common;


import java.util.Map;

public class PropertyInitializer {


    public static void setSystemProperties(Map<String, String> properties) {
        System.setProperty("CONFIG.BASEPATH", "environment/");
        System.setProperty("environment.chrome.headless", "true");
        System.setProperty("environment.rerun.count", "0");
        properties.forEach(System::setProperty);

    }
}
