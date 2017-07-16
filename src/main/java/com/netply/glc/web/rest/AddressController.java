package com.netply.glc.web.rest;

import com.netply.glc.web.rest.address.AddressManager;
import com.netply.glc.web.rest.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    private AddressManager addressManager;


    @Autowired
    public AddressController(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @RequestMapping(value = "/address", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void editAddress(
            @RequestParam(value = "gymnastId") Integer gymnastId,
            @RequestBody Address address) {
        addressManager.editAddress(gymnastId, address);
    }

    @RequestMapping(value = "/address", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddress(
            @RequestParam(value = "gymnastId") Integer gymnastId) {
        return addressManager.getAddress(gymnastId);
    }
}
