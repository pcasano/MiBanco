package org.example.service;

import org.example.model.Transaction;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount) {


        // TODO real pdf creation and storing it on network server
        Transaction transaction = new Transaction(amount, "http://www.africau.edu/images/default/sample.pdf", "ref");
        transactions.add(transaction);
        return transaction;
    }

}
