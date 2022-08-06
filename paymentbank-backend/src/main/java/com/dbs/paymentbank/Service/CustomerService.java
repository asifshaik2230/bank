package com.dbs.paymentbank.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.paymentbank.Model.Customer;
import com.dbs.paymentbank.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	 public Optional<Customer> getCustomerById(String cid) {
	        return customerRepository.findById(cid);
	    }
	 
}
