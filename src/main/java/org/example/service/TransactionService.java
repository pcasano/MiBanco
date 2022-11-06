package org.example.service;

import org.example.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@PropertySource("classpath:/application.properties")
public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();
    @Value("${bank.slogan}")
    private String ref;

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount) {


        // TODO real pdf creation and storing it on network server
        Transaction transaction = new Transaction(amount, "http://www.africau.edu/images/default/sample.pdf", ref);
        transactions.add(transaction);
        return transaction;
    }

}
