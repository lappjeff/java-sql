package lambda.javasql.repos;

import lambda.javasql.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
	Customer findByCustname(String name);
}
