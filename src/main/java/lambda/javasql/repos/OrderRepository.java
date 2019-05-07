package lambda.javasql.repos;

import lambda.javasql.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
}
