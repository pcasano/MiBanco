package org.example.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.context.ApplicationConfiguration;
import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyTransactionServlet extends HttpServlet {


    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        transactionService = ctx.getBean(TransactionService.class);
        objectMapper = ctx.getBean(ObjectMapper.class);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {

            Integer amount = Integer.valueOf(request.getParameter("amount"));

            Transaction transaction = transactionService.create(amount);

            response.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(transaction);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, Transacions</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.findAll();
            response.getWriter().print(objectMapper.writeValueAsString(transactions));
        }
    }

}
