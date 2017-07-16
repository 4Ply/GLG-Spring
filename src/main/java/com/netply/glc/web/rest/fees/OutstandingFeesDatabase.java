package com.netply.glc.web.rest.fees;

import com.netply.glc.web.rest.pojo.BasicGymnast;

import java.util.List;

public interface OutstandingFeesDatabase {
    List<BasicGymnast> getGymnastsWithOutstandingFees();
}
