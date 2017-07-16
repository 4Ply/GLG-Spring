package com.netply.glc.web.rest.fees;

import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.Transaction;

import java.util.List;

public interface OutstandingFeesManager {
    List<BasicGymnast> getGymnastsWithOutstandingFees();

    List<Transaction> getInvoice(int gymnastId);
}
