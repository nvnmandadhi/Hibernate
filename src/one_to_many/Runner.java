package one_to_many;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/one_to_many/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Orders obj1 = new Orders();

		List<OrderItem> list = new ArrayList<>();

		list.add(new OrderItem("ball", 2));
		list.add(new OrderItem("pen", 4));

		obj1.setName("regular");
		obj1.setAddress("919 Ridge Dr");
		obj1.setOrderItems(list);

		session.save(obj1);

		list = new LinkedList<>();

		list.add(new OrderItem("razer", 4));
		list.add(new OrderItem("shaving kit", 6));

		Orders obj2 = new Orders("normal", "46 Ballpark Avenue", list);

		session.save(obj2);

		session.close();
	}

}
