package lambda.javasql.service;

import lambda.javasql.model.Customer;

import java.util.List;

public interface CustomerService
{
	List<Customer> findAll();

	Customer findCustomerByName(String name);

	Customer findCustomerById(long id);

	Customer save(Customer customer);

	Customer update(Customer customer, long id);

	void delete(long id);



}
