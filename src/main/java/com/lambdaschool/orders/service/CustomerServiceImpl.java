package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomersRepository restrepos;

	@Override
	public List<Customers> findAll()
	{
		ArrayList<Customers> list = new ArrayList<>();
		restrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Customers findCustomerByCustName(String name) throws EntityNotFoundException
	{
		Customers customers = restrepos.findByCustname(name);

		if (customers == null)
		{
			throw new EntityNotFoundException("Customers " + name + " not found");
		}

		return customers;

	}

	@Override
	public Customers findCustomerById(long id) throws EntityNotFoundException
	{
		return restrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
	}

	@Transactional
	@Override
	public Customers save(Customers customers)
	{
		Customers newCustomers = new Customers();

		newCustomers.setAgent((customers.getAgent()));
		newCustomers.setCustcity(customers.getCustcity());
		newCustomers.setCustcode(customers.getCustcode());
		newCustomers.setCustcountry(customers.getCustcountry());
		newCustomers.setCustname(customers.getCustname());
		newCustomers.setGrade(customers.getGrade());
		newCustomers.setOpeningamt(customers.getOpeningamt());
		newCustomers.setOutstandingamt(customers.getOutstandingamt());
		newCustomers.setReceiveamt(customers.getReceiveamt());
		newCustomers.setPaymentamt(customers.getPaymentamt());
		newCustomers.setPhone(customers.getPhone());
		newCustomers.setWorkingarea(customers.getWorkingarea());

		for(Orders o : customers.getOrders())
		{
			customers.getOrders().add(new Orders(
					o.getOrdamount(),
					o.getAdvanceamount(),
					o.getCustcode(),
					o.getAgentcode(),
					o.getOrddescription()));
		}

		return restrepos.save(newCustomers);
	}

	@Transactional
	@Override
	public Customers update(Customers customers, long id) throws EntityNotFoundException
	{
		Customers currentCustomers = restrepos.findById(id).
				orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
		if (customers.getCustname() != null)
		{
			currentCustomers.setCustname(customers.getCustname());
		}

		if (customers.getCustcity() != null)
		{
			currentCustomers.setCustcity(customers.getCustcity());
		}

		if (customers.getCustcountry() != null)
		{
			currentCustomers.setCustcountry(customers.getCustcountry());
		}

		if (customers.getGrade() != null)
		{
			currentCustomers.setGrade(customers.getGrade());
		}

		if (customers.getOrders().size() > 0)
		{
			for (Orders m : customers.getOrders())
			{
				currentCustomers.getOrders().add(new Orders(m.getOrdamount(), m.getAdvanceamount(), m.getCustcode(),
						m.getAgentcode(), m.getOrddescription()));
			}
		}

		return restrepos.save(currentCustomers);

	}

	@Override
	public void delete(long id) throws EntityNotFoundException
	{
		if(restrepos.findById(id).isPresent())
		{
			restrepos.deleteById(id);
		} else
		{
			throw new EntityNotFoundException(Long.toString(id));
		}
	}
}
