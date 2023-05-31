package pl.kielce.tu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.entity.Person;
import pl.kielce.entity.Student;

public class QueryTest {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//Session session = factory.getCurrentSession(); //session.beginTransaction();
		
		try {
				session.beginTransaction();
				List<Person> theStudents = session.createQuery("from Student").list();
			
				displayStudents(theStudents);
				
				theStudents = session.createQuery("from Person  ").list();
				
//				//Students last name of Daniels OR first name Martin
//				theStudents = session.createQuery("from Student s where s.lastName = 'Daniels' OR"
//						+ " s.firstName = 'Martin'").list();
				
				session.getTransaction().commit();
				
				displayStudents(theStudents);
				
				System.out.println("\nDone !");
		
		}finally {
			factory.close();
		}
	}

	
	private static void displayStudents(List<Person> theStudents) {
		for(Person tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
