package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Mobile;



public interface CartRepository extends JpaRepository<Cart, Integer>{

	Cart findByCustomerAndMobile(Customer customer, Mobile mobile);

	 @Modifying
	    @Query("DELETE FROM Cart c WHERE c.customer.customerId = :customerId AND c.mobile.mobileId = :mobileId")
	    void deleteByCustomerIdAndMobileId(@Param("customerId") Integer customerId, @Param("mobileId") Integer mobileId);

	
}
