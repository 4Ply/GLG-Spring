package com.netply.glc.web.rest.transaction;

import com.netply.glc.web.rest.pojo.Transaction;

import java.util.List;

public interface TransactionManager {
    void addTransaction(int gymnastId, Transaction transaction);

    List<Transaction> getTransactions(int gymnastId);
}
