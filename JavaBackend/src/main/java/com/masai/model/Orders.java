package com.masai.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int orderId;
	    private Date orderDate;
	    
	    @ManyToOne
	    @JoinColumn(name="customer_id")
	    private Customer customer;
	    
	    private String status;
	    @OneToMany
	    private List<Cart> cart;
}
