package com.abc_telecom_Ltd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.Customer;
import com.abc_telecom_Ltd.repository.CustomerReposisoty;

@Service
public class CustomerServiceImp implements CustomerService{

	
	@Autowired
	private CustomerReposisoty customerReposisoty;

	@Override
	public Customer addCutomer(Customer cutomer) {
		return customerReposisoty.save(cutomer);
	}

	@Override
	public void deleteCutomer(Long id) {
		customerReposisoty.deleteById(id);
	}
	
}
