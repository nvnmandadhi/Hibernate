package CarRunner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/one_to_one/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee employee = new Employee("Rob", new Address("919 Ridge Drive", 60115));

		session.save(employee);

		Employee obj = session.load(Employee.class, 1);

		System.out.println(obj);

		session.close();

	}
}
