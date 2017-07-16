package com.netply.glc.web.rest.address;

import com.netply.glc.web.rest.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressManagerImpl implements AddressManager {
    private AddressDatabase addressDatabase;


    @Autowired
    public AddressManagerImpl(AddressDatabase addressDatabase) {
        this.addressDatabase = addressDatabase;
    }

    @Override
    public void editAddress(int gymnastId, Address address) {
        addressDatabase.editAddress(gymnastId, address);
    }

    @Override
    public Address getAddress(int gymnastId) {
        return addressDatabase.getAddress(gymnastId);
    }
}
