package com.netply.glc.web.rest;

import com.netply.glc.web.rest.pojo.Transaction;
import com.netply.glc.web.rest.pojo.TransactionType;
import com.netply.glc.web.rest.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {
    private TransactionManager transactionManager;


    @Autowired
    public TransactionController(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @RequestMapping(value = "/transaction", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public void addTransaction(
            @RequestParam(value = "gymnastId") Integer gymnastId,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "amount") Double amount,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "method") String method,
            @RequestParam(value = "notes") String notes) {
        transactionManager.addTransaction(gymnastId, new Transaction(gymnastId, date, amount, type, method, notes));
    }

    @RequestMapping(value = "/transactions", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> getTransactions(
            @RequestParam(value = "gymnastId") Integer gymnastId) {
        return transactionManager.getTransactions(gymnastId);
    }

    @RequestMapping(value = "/transactionTypes", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<TransactionType> getTransactionTypes() {
        ArrayList<TransactionType> transactionTypes = new ArrayList<>();
        transactionTypes.add(new TransactionType("Monthly fees", 1));
        transactionTypes.add(new TransactionType("Registration fees", 2));
        return transactionTypes;
    }

    @RequestMapping(value = "/transactionMethods", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<TransactionType> getTransactionMethods() {
        ArrayList<TransactionType> transactionTypes = new ArrayList<>();
        transactionTypes.add(new TransactionType("EFT", 1));
        transactionTypes.add(new TransactionType("Cash to Dorora", 2));
        transactionTypes.add(new TransactionType("Cash to Claudia", 3));
        return transactionTypes;
    }
}
