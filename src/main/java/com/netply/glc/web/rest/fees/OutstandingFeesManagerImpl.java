package com.netply.glc.web.rest.fees;

import com.netply.glc.web.rest.event.EventManager;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.Event;
import com.netply.glc.web.rest.pojo.Transaction;
import com.netply.glc.web.rest.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutstandingFeesManagerImpl implements OutstandingFeesManager {
    private OutstandingFeesDatabase outstandingFeesDatabase;
    private TransactionManager transactionManager;
    private EventManager eventManager;


    @Autowired
    public OutstandingFeesManagerImpl(OutstandingFeesDatabase outstandingFeesDatabase, TransactionManager transactionManager, EventManager eventManager) {
        this.outstandingFeesDatabase = outstandingFeesDatabase;
        this.transactionManager = transactionManager;
        this.eventManager = eventManager;
    }

    @Override
    public List<BasicGymnast> getGymnastsWithOutstandingFees() {
        return outstandingFeesDatabase.getGymnastsWithOutstandingFees();
    }

    @Override
    public List<Transaction> getInvoice(int gymnastId) {
        List<Transaction> transactions = transactionManager.getTransactions(gymnastId);
        List<Event> events = eventManager.getEvents(gymnastId);

        transactions.addAll(events.stream().map(event -> new Transaction(gymnastId, event.getDate(), 0.0, event.getType(), null, null)).collect(Collectors.toList()));
        return transactions.stream().sorted(Comparator.comparing(Transaction::getDate)).collect(Collectors.toList());
    }
}
