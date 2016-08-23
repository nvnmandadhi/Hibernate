package energy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("/basic/hibernate.cfg.xml")
				.addAnnotatedClass(EnergyData.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		EnergyData obj = new EnergyData(325, 5, 50, 50, 40);

		session.save(obj);

		session.getTransaction().commit();
		session.close();
	}

}
