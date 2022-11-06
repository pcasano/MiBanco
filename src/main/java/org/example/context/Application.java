package org.example.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Transaction;
import org.example.service.TransactionService;

public class Application {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final TransactionService transactionService = new TransactionService();
}
