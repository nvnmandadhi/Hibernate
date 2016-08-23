package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class Runner {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("/basic/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Student> students = new ArrayList<>();

		students.add(new Student("Michael"));
		students.add(new Student("Dave"));
		students.add(new Student("Tom"));
		students.add(new Student("Diggle"));
		students.add(new Student("Lakshman"));
		students.add(new Student("Cruise"));

		for (Student student : students) {
			session.save(student);
		}

		Student newStudent = new Student("Bob");
		Student healey = new Student("Healey");

		session.save(newStudent);
		session.save(healey);

		newStudent.setName("Arrow");

		session.getTransaction().commit();
		session.close();

		newStudent.setName("Flash");

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(newStudent);

		Query query = session.createQuery("from Student where id=?");
		query.setParameter(0, 1);

		List<Student> resultList = (List<Student>) query.getResultList();

		for (Iterator<Student> iterator = resultList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}

		Criteria criteria = session.createCriteria(Student.class).addOrder(Order.desc("id"));
		List<Student> list = criteria.list();

		for (Student student : list) {
			System.out.println(student);
		}

		criteria = session.createCriteria(Student.class).setProjection(Projections.rowCount());

		Long uniqueResult = (Long) criteria.uniqueResult();

		System.out.println(uniqueResult.intValue());
		
		session.getTransaction().commit();
		session.close();

	}

}
