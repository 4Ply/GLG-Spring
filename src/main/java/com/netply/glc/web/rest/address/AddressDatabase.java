package com.netply.glc.web.rest.address;

import com.netply.glc.web.rest.pojo.Address;

public interface AddressDatabase {
    void editAddress(int gymnastId, Address address);

    Address getAddress(int gymnastId);
}
