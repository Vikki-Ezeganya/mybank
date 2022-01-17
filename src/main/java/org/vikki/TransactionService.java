package org.vikki;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {
    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public Transaction createTransaction(Integer amount, String reference) {
        Transaction transaction = new Transaction(amount, reference);
        this.transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAllTransactions() {
        return this.transactions;
    }

}
