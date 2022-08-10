package com.dbs.paymentbank.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.paymentbank.Model.BankBic;
import com.dbs.paymentbank.Model.Customer;
import com.dbs.paymentbank.Model.MessageCode;
import com.dbs.paymentbank.Model.Transaction;
import com.dbs.paymentbank.Model.TransactionRequest;
import com.dbs.paymentbank.Repository.BankRepo;
import com.dbs.paymentbank.Repository.CustomerRepository;
import com.dbs.paymentbank.Repository.MessageRepository;
import com.dbs.paymentbank.Repository.TransactionRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	MessageRepository messageCodeRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	
	private Transaction storeTransaction(Customer customer, Double totalAmount,TransactionRequest payload, BankBic bankbic,MessageCode messageCode, String status, String reason) {
		
		Transaction transactionItem =new Transaction();
		transactionItem.setCustomer(customer);
        transactionItem.setAmount(totalAmount);
        transactionItem.setTransferCode(payload.getTransferTypeCode());
        transactionItem.setTimestamp(new java.util.Date());
        transactionItem.setReceiverBIC(bankRepo.findById(payload.getReceiverBIC()).get());
        transactionItem.setMessageCode(messageCodeRepository.findById(payload.getMessageCode()).get());
        transactionItem.setReceiverAccountNumber(payload.getReceiverAccountNumber());
        transactionItem.setReceiverName(payload.getReceiverAccountName());
        transactionItem.setStatus(status);
        transactionItem.setFailureReason(reason);
        return transactionRepository.save(transactionItem);
		
	}
	 public Optional<Customer> getCustomerById(String cid) {
	        return customerRepository.findById(cid);
	    }

	public Optional<BankBic> getBankByBIC(String bic) {
		// TODO Auto-generated method stub
		return bankRepo.findById(bic);
	}

	public String processTransaction(TransactionRequest request) {
		System.out.println(request);
		 Customer customer = customerRepository.findById((request.getCustomerId())).get();
		  Double transferFee = 0.0025 * request.getAmount();
	        Double totalAmount = request.getAmount() + transferFee;
	        if (customer.getClearBalance() < totalAmount && !customer.getOverDraft()) {
	            storeTransaction(customer, totalAmount, request, bankRepo.findById(request.getReceiverBIC()).get(), messageCodeRepository.findById(request.getMessageCode()).get(), "Failed", "Insufficient Balance in Bank Account");
	            return "No Enjoy Pandagoo......";
	        }
	        
	      storeTransaction(customer, totalAmount, request, bankRepo.findById(request.getReceiverBIC()).get()
	                , messageCodeRepository.findById(request.getMessageCode()).get(), "SUCCESS", null);
	        customer.setClearBalance(customer.getClearBalance() - Math.abs(totalAmount));
	        customerRepository.save(customer);
		return "Enjoy Pandagoo......";
	}
	
	 
}
