package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Customers;

import java.util.List;

public interface CustomerService
{
	List<Customers> findAll();

	Customers findCustomerByCustName(String name);

	Customers findCustomerById(long id);

	Customers save(Customers customers);

	Customers update(Customers customers, long id);

	void delete(long id);



}
