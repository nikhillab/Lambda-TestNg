package org.lambda.test;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TestRunner {
    public static void main(String[] args) throws IOException {

        final var httpServer = HttpServer.create(new InetSocketAddress(8000), 0);

        httpServer.createContext("/test", new MyHandler());
        httpServer.setExecutor(Executors.newCachedThreadPool()); // creates a default executor
        httpServer.start();

//        System.setProperty("environment.id", "INFRA");
//        System.setProperty("environment.hostname", "");
//        System.setProperty("environment.chrome.version", "116");
//        System.setProperty("environment.chrome.headless", "true");
//        System.setProperty("environment.rerun.count", "0");
//        System.setProperty("environment.pod.name", "");
//

//
//        ObjectMapper objectMapper = new ObjectMapper();
//        TestRequest stringStringMap = objectMapper.readValue(pal, new TypeReference<TestRequest>() {
//        });
//
//        System.out.println(stringStringMap.getEnvironment());
//        System.out.println(stringStringMap.getClassName());


//
//        Set<String> lib = Files.walk(Paths.get("lib"))
//                .map(Path::getFileName)
//                .map(Path::toFile)
//                .map(File::getName)
//                .filter(name -> name.endsWith(".jar"))
//                .map(name -> name.substring(0, name.lastIndexOf('-')))
//                .collect(Collectors.toSet());
//        System.out.println(lib.size());
//
//        Set<String> dep = Files.walk(Paths.get("target/dependency"))
//                .map(Path::getFileName)
//                .map(Path::toFile)
//                .map(File::getName)
//                .filter(name -> name.endsWith(".jar"))
//                .map(name -> name.substring(0, name.lastIndexOf('-')))
//                .collect(Collectors.toSet());
//        System.out.println(dep.size());
//        TreeSet treeSet = new TreeSet(lib);
//        treeSet.retainAll(dep);
//        System.out.println(treeSet.size());
//
//        treeSet = new TreeSet(dep);
//        treeSet.removeAll(lib);
//        System.out.println(treeSet);


    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}