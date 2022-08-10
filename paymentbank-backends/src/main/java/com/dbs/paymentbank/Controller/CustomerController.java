package com.dbs.paymentbank.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.paymentbank.Model.BankBic;
import com.dbs.paymentbank.Model.Customer;
import com.dbs.paymentbank.Model.MessageCode;
import com.dbs.paymentbank.Model.TransactionRequest;
import com.dbs.paymentbank.Service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CustomerController {
	
    @Autowired
	CustomerService customerService;
   
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
	  @GetMapping("bank/{bic}")
	 
	    public Optional<BankBic> getBankByBIC(@PathVariable String bic) {
		  
		  try {
				Optional<BankBic> customer = customerService.getBankByBIC(bic);
		        System.out.println(customer);
		        return customer;
		        }
		        catch(Exception e)
		        {
		        	return null;
		        }

	    }
	  @GetMapping("messageCode")
	    public List<MessageCode> getAllMessageCodes() {
	        return customerService.getMessageCodes();
	    }
	  @PostMapping("transaction")
	    public String processTransaction(@RequestBody TransactionRequest request) {
		  System.out.print(request);
	        return customerService.processTransaction(request);
	    }
}
