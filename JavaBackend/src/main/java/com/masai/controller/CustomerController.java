package com.masai.controller;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.service.CustomerServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerServiceInterface customerServiceInterface;
	
	@Autowired
	private CustomerRepository customerRepository;
	// customer Register
	@PostMapping("/add")
	ResponseEntity<Customer> registerUser( @RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setRole("user");
		System.out.println("working");
		return new ResponseEntity<Customer>(customerServiceInterface.addCustomer(customer),HttpStatus.CREATED);
	}
	
	//customer Login
	@GetMapping("/logini")
	public ResponseEntity<Customer> logInUserHandler(Authentication auth){
		 Optional<Customer> opt= customerRepository.findByEmail(auth.getName());
		 
		 if(opt.isEmpty()) throw new RuntimeException("No user found") ;
		 Customer user = opt.get();
		 
		 return new ResponseEntity<Customer>(user, HttpStatus.OK);
	}
}
