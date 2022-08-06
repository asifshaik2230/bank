package com.dbs.paymentbank.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.paymentbank.Model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
    @Autowired
	CustomerController customerService;

	@GetMapping("customer/{cid}")
    public Optional<Customer> getCustomerById(@PathVariable String cid) {
        try {
		Optional<Customer> customer = customerService.getCustomerById(cid);
        System.out.println(customer);
        return customer;
        }
        catch(Exception e)
        {
        	return null;
        }
       
	}
}
