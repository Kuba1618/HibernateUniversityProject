package pl.kielce.tu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.kielce.entity.Car;
import pl.kielce.entity.Course;
import pl.kielce.entity.Motorcycle;
import pl.kielce.entity.Professor;
import pl.kielce.entity.Student;

public class HibernateTest {

	public static void main(String[] args) {
		//Faker faker = new Faker(new Locale("pl-PL"));
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		for(int i = 0 ;i < 500;i++) {
			
			Car car = new Car();
		    car.generateCarData();
			
		    Professor prof = new Professor();
			prof.generateProfessorData();
			prof.setVehicle(car);
			car.setProfessor(prof);
			
	        Course course = new Course();
	        course.generateCourseData();
	        course.setProfessor(prof);
	        prof.setCourse(course);
	        
	        Motorcycle moto = new Motorcycle();
	        moto.generateMotorcycleData();
			
//	        ------------  Generate some students ----------
//			List<Student> listOfStudents = new ArrayList<>();
//			for(int j = 0 ; j < 10;j++) {
				Student student = new Student();
				student.generateStudentData();
				student.setCourse(course);
				student.setMotorcycle(moto);
//				listOfStudents.add(student);
//			}
//			//---------- Add list of students to created earlier course
//			course.setListOfStudents(listOfStudents);
			
			
			session.save(car); //before saving the professor
			session.save(prof);
			session.save(course); // before saving the student
			session.save(moto); // before saving the student
			session.save(student);
//			for(Student s : listOfStudents) {
//				session.save(s);
//			}

		}
		
		session.getTransaction().commit();
		
		session.close();

	}

}
