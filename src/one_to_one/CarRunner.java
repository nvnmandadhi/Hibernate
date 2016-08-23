package one_to_one;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CarRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Car.class).addAnnotatedClass(Part.class)
				.addAnnotatedClass(Engine.class).configure("/one_to_one/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Car car = new Car();

		List<Part> parts = new ArrayList<>();
		parts.add(new Part("steering"));
		parts.add(new Part("seats"));
		parts.add(new Part("roof"));

		car.setParts(parts);

		car.setCar_name("Audi");
		car.setEngine(new Engine("V6"));

		session.save(car);

		session.close();

	}
}
