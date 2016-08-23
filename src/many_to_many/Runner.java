package many_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("/many_to_many/hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		List<Product> products = new ArrayList<>();
		List<Customer> customers = new ArrayList<>();
		
		products.add(new Product("pen", customers));

		
		customers.add(new Customer("Bob", products));

		session.save(new Customer("Bob", products));
	}

}
