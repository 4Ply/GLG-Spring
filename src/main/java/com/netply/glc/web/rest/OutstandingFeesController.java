package com.netply.glc.web.rest;

import com.netply.glc.web.rest.fees.OutstandingFeesManager;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OutstandingFeesController {
    private OutstandingFeesManager outstandingFeesManager;


    @Autowired
    public OutstandingFeesController(OutstandingFeesManager outstandingFeesManager) {
        this.outstandingFeesManager = outstandingFeesManager;
    }

    @RequestMapping(value = "/missingRegistrationFees", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicGymnast> getMissingRegistrationFees() {
        return outstandingFeesManager.getGymnastsWithOutstandingFees().stream().distinct().collect(Collectors.toList());
    }

    @RequestMapping(value = "/invoice", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> getInvoice(
            @RequestParam(value = "gymnastId") Integer gymnastId) {
        return outstandingFeesManager.getInvoice(gymnastId).stream().distinct().collect(Collectors.toList());
    }
}
