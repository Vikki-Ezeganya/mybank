package org.vikki;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        ObjectMapper objectMapper = Application.objectMapper;
        TransactionService transactionService = Application.transactionService;
        Wrapper servlet = Tomcat.addServlet(ctx, "myBankServlet", new MyBankServlet(objectMapper, transactionService));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
        tomcat.start();
    }
}
