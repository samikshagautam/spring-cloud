package com.ea.account.service;

import com.ea.account.entity.ShippingAddress;
import com.ea.account.repository.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingAddressRepository repository;

    public ShippingAddress addAddress(ShippingAddress address) {
        return repository.save(address);
    }

    public ShippingAddress getAddressById(Long id) {
        return repository.findById(id).get();
    }

    public ShippingAddress updateAddress(ShippingAddress address, Long id) throws Exception {
        ShippingAddress shippingAddress = getAddressById(id);

        if (shippingAddress == null) {
            throw new Exception("Shipping address not found!");
        }

        shippingAddress.setAddress1(address.getAddress1());
        shippingAddress.setAddress2(address.getAddress2());
        shippingAddress.setCity(address.getCity());
        shippingAddress.setPhoneNum(address.getPhoneNum());
        shippingAddress.setState(address.getState());
        shippingAddress.setZipCode(address.getZipCode());

        return repository.save(shippingAddress);
    }


    public ShippingAddress deleteAddress(Long id) throws Exception {
        ShippingAddress shippingAddress = getAddressById(id);

        if (shippingAddress == null) {
            throw new Exception("Address not found");
        }

        repository.delete(shippingAddress);
        return shippingAddress;

    }
}
