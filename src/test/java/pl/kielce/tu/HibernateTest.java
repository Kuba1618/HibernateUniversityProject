package pl.kielce.tu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.entity.Car;
import pl.kielce.entity.Professor;
import pl.kielce.entity.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		//Faker faker = new Faker(new Locale("pl-PL"));
		
		Car vehicle = new Car();
		vehicle.generateCarData();
		
		Professor prof = new Professor();
		prof.generateProfessorData();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(prof);
		
		session.getTransaction().commit();
		
		session.close();

	}

}
