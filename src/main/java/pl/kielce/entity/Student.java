package pl.kielce.entity;
import java.util.List;
import java.util.Random;

import javax.persistence.*;


@Entity(name="Student")
public class Student extends Person{
    
    @Column(name="grade_average")
    private float gradeAverage;
    @Column(name="employed")
    private boolean employed;
    @OneToOne
    private Course course;
    @OneToOne
    private Motorcycle motorcycle;
    
    public Student(){

    }
    
    public Student(float gradeAverage, boolean employed, Course course) {
        this.gradeAverage = gradeAverage;
        this.employed = employed;
        this.course = course;
    }

    public float getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(float gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Motorcycle getMotorcycle() {
		return motorcycle;
	}

	public void setMotorcycle(Motorcycle motorcycle) {
		this.motorcycle = motorcycle;
	}

	public void generateStudentData()
    {
        Random r = new Random();
        //Faker faker = new Faker(new Locale("pl-PL"));
        
        generatePersonData();
        float randomAverage = Math.round((r.nextFloat() * (5.0F - 2.5F) + 2.5F) * 10.0F) / 10.0F;
        setGradeAverage(randomAverage);
        boolean randomEmployed = r.nextInt()%2 == 0;
        setEmployed(randomEmployed);
       
    }

}

