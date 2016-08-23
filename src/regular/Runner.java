package regular;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/regular/hibernate.cfg.xml")
				.addAnnotatedClass(CustomerDetails.class).addAnnotatedClass(OrderDetails.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CustomerDetails customer = new CustomerDetails();
		customer.setContactName("Robert and Bosch");
		customer.setCustomerName("Robert Bosch");
		customer.setAddress("404 California Ave");
		customer.setCity("California");
		customer.setPostalCode("60466");
		customer.setCountry("USA");

		List<OrderDetails> orders = new ArrayList<>();
		orders.add(new OrderDetails("Car", 4));
		orders.add(new OrderDetails("Headphones", 6));

		customer.setOrder(orders);

		session.save(customer);

		session.getTransaction().commit();
		session.close();
	}

}
