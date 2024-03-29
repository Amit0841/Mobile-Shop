package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface{
	
@Autowired
private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

}
