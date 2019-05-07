package lambda.javasql.service;

import lambda.javasql.model.Customer;
import lambda.javasql.model.Order;
import lambda.javasql.repos.CustomerRepository;
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
	private CustomerRepository restrepos;

	@Override
	public List<Customer> findAll()
	{
		ArrayList<Customer> list = new ArrayList<>();
		restrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Customer findCustomerByName(String name) throws EntityNotFoundException
	{
		Customer customer = restrepos.findByCustname(name);

		if (customer == null)
		{
			throw new EntityNotFoundException("Customer " + name + " not found");
		}

		return customer;

	}

	@Transactional
	@Override
	public Customer save(Customer customer)
	{
		Customer newCustomer = new Customer();

		newCustomer.setAgentcode((customer.getAgentcode()));
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setCustcode(customer.getCustcode());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setCustname(customer.getCustname());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setWorkingarea(customer.getWorkingarea());

		for(Order o : customer.getOrders())
		{
			customer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), o.getOrddescription(),
					o.getCustcode(), o.getAgentcode()));
		}

		return restrepos.save(newCustomer);
	}

	@Transactional
	@Override
	public Customer update(Customer customer, long id) throws EntityNotFoundException
	{
		Customer currentCustomer = restrepos.findById(id).
				orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
		if (customer.getCustname() != null)
		{
			currentCustomer.setCustname(customer.getCustname());
		}

		if (customer.getCustcity() != null)
		{
			currentCustomer.setCustcity(customer.getCustcity());
		}

		if (customer.getCustcountry() != null)
		{
			currentCustomer.setCustcountry(customer.getCustcountry());
		}

		if (customer.getGrade() != null)
		{
			currentCustomer.setGrade(customer.getGrade());
		}

		

	}

	@Override
	public void delete(long id)
	{

	}
}
