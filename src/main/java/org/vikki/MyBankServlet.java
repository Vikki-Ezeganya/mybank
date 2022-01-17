package org.vikki;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyBankServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getRequestURI().equals("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if(request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");



            var transactions = ServiceFactory.transactionService().findAllTransactions();

            response.getWriter().print(objectMapper.writeValueAsString(transactions));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        if(request.getRequestURI().equalsIgnoreCase("/transactions")) {
           Integer amount = Integer.parseInt(request.getParameter("amount"));
           String  reference = request.getParameter("reference");

           Transaction transaction = ServiceFactory.transactionService().createTransaction(amount, reference);
           response.setContentType("application/json; charset=UTF-8");
           objectMapper.findAndRegisterModules();
           String json = objectMapper.writeValueAsString(transaction);
           response.getWriter().print(json);

        } else  {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
