
package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String mobileNumber;
	
	private String address;
	
	private String role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Orders> orderList1=new ArrayList<>();
	

//	@JsonIgnore
//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//	private List<Cart> cart;

	
}
