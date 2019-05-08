package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	//localhost:8080/customer/orders
	@GetMapping(value = "/customer/orders", produces = {"application/json"})
	public ResponseEntity<?> listAllOrders()
	{
		List<Customers> myCustomers = customerService.findAll();
		return new ResponseEntity<>(myCustomers, HttpStatus.OK);
	}
}
