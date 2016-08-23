package persisting_collections;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/persisting_collections/hibernate.cfg.xml")
				.addAnnotatedClass(Cars.class).addAnnotatedClass(Showroom.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Cars> cars = new ArrayList<>();

		cars.add(new Cars("Audi"));
		cars.add(new Cars("Benz"));
		cars.add(new Cars("Chevy"));
		cars.add(new Cars("Mercedes"));

		Showroom showroom = new Showroom();
		showroom.setShowroom_name("Brian Bemis");
		showroom.setCars(cars);

		session.save(showroom);

		session.close();

	}

}
