package pl.kielce.tu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.entity.Car;
import pl.kielce.entity.Motorcycle;
import pl.kielce.entity.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		//Faker faker = new Faker(new Locale("pl-PL"));
		
		Vehicle vehicle = new Vehicle();
		vehicle.generateVehicleData();
		
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.generateData();
		Car car = new Car();
		car.generateData();		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(motorcycle);
		session.save(car);
		
		session.getTransaction().commit();
		
		session.close();

	}

}
