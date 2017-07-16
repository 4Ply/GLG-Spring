package com.netply.glc.web.rest.transaction;

import com.netply.glc.web.rest.pojo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionManagerImpl implements TransactionManager {
    private TransactionDatabase transactionDatabase;


    @Autowired
    public TransactionManagerImpl(TransactionDatabase transactionDatabase) {
        this.transactionDatabase = transactionDatabase;
    }

    @Override
    public void addTransaction(int gymnastId, Transaction transaction) {
        transactionDatabase.addTransaction(gymnastId, transaction);
    }

    @Override
    public List<Transaction> getTransactions(int gymnastId) {
        return transactionDatabase.getTransactions(gymnastId);
    }
}
