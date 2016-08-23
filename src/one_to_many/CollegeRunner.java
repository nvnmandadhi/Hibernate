package one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CollegeRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/one_to_many/hibernate.cfg.xml")
				.addAnnotatedClass(StudentDetails.class).addAnnotatedClass(CollegeDetails.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<StudentDetails> students = new ArrayList<>();
		students.add(new StudentDetails("Robert"));
		students.add(new StudentDetails("Michael"));

		CollegeDetails college = new CollegeDetails("NIU", students);

		session.save(college);

		session.getTransaction().commit();

	}

}
