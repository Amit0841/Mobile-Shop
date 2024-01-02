package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Mobile;
import com.masai.model.Orders;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.MobileRepository;
import com.masai.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class MobileService implements MobileServiceInterface{
	@Autowired 
	private MobileRepository mobileRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Mobile add(Mobile mobile) {
		mobileRepository.save(mobile);
		return mobile;
	}
	@Override
	public List<Mobile> getMobiles() {
		List<Mobile> listM=mobileRepository.findAll();
		return listM;
	}
	@Override
	public Mobile getMobilesById(Integer mobileId) {
		Optional<Mobile> mobile=mobileRepository.findById(mobileId);
		return mobile.get();
	}
	
	@Override
	public Mobile addToCart(Cart cart, Integer customerId, Integer mobileId) {
		Optional<Mobile> m=mobileRepository.findById(mobileId);
		Optional<Customer> cus=customerRepository.findById(customerId);
		Cart c=cartRepository.findByCustomerAndMobile(cus.get(),m.get());
		if(c!=null) {
			throw new  RuntimeException("Item already added");
		}else {
			cart.setCustomer(cus.get());
			cart.setMobile(m.get());
		cartRepository.save(cart);	
		return m.get();
		}
		
	}
	@Override
	public List<Mobile> getCart(Integer customerId) {
		Optional<Customer> cus=customerRepository.findById(customerId);
		
		List<Cart> list=cartRepository.findAll();
		List<Mobile> l=new ArrayList();
		for(Cart c:list) {
			if(c.getCustomer().getCustomerId()==customerId) {
				l.add(c.getMobile());
			}
		}
		return l;
	}
	
	@Override
	@Transactional
	public Cart deleteCart(Integer customerId, Integer mobileId) {
		 
//		cartRepository.deleteByCustomerIdAndMobileId(customerId,mobileId);
		List<Cart> c=cartRepository.findAll();
		for(Cart c1:c) {
			if(c1.getCustomer().getCustomerId()==customerId && c1.getMobile().getMobileId()==mobileId) {
				cartRepository.delete(c1);
			}
		}
		return null;
	}
	
	@Override
	public Cart orderCart(Integer customerId) {
Optional<Customer> cus=customerRepository.findById(customerId);
		
		List<Cart> list=cartRepository.findAll();
		List<Cart> list1=new ArrayList();
		List<Mobile> l=new ArrayList();
		for(Cart c:list) {
			if(c.getCustomer().getCustomerId()==customerId) {
				l.add(c.getMobile());
				list1.add(c);
			}
		}
		Orders o=new Orders();
		o.setCustomer(cus.get());
        o.setCart(list1);
		orderRepository.save(o);
		return null;
	}
	
	@Override
	public List<Orders> getOrder(Integer customerId) {
		List<Orders> ord=orderRepository.findByCustomerCustomerId(customerId);
		return ord;
	}
	@Override
	public List<Mobile> find( String name) {
		
		List<Mobile> mobile=mobileRepository.findByMobileNameIgnoreCaseContaining(name);
		
		return mobile;
	}
	@Override
	public Mobile deleteById(Integer mobileId) {
		Optional<Mobile> mobile=mobileRepository.findById(mobileId);
		mobileRepository.deleteById(mobileId);
		return mobile.get();
	}

}
