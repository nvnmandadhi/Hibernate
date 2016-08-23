package many_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/many_to_one/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).addAnnotatedClass(ContactNumber.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setName("Michael");

		ContactNumber contactNumber = new ContactNumber("19829819829");
		contactNumber.setCustomer(customer);

		session.save(contactNumber);

		session.close();
	}

}
