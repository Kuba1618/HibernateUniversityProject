package pl.kielce.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name="Professor")
public class Professor extends Person{
 
    @Column(name="insurance_number")
    private long insuranceNumber;
    @OneToOne
    private Car car;
    @OneToOne
    private Course course;

    public Professor() {
    
    }
    
    public Professor(long insuranceNumber, Car car) {
    	super();
    	this.insuranceNumber = insuranceNumber;
    	this.car = car;
    }

	public Professor(int insuranceNumber, Car car, Course course) {
        this.insuranceNumber = insuranceNumber;
        this.car = car;
        this.course = course;
    }

    public Professor(String firstName, String lastName, Gender gender, Address addressInfo, String email, int phone, int insuranceNumber, Car car, Course course) {
        super(firstName, lastName, gender, addressInfo, email, phone);
        this.insuranceNumber = insuranceNumber;
        this.car = car;
        this.course = course;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setVehicle(Car car) {
        this.car = car;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString(){
        return "Proffesor{" +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", car='" + car.toString() + '\'' + //vehicle.toString() or vehicle.getVehicleId()
                ", listOfCourse='" + " " + '\'' +
                '}';
    }

    public void generateProfessorData()
    {
    	Random generator = new Random();
        generatePersonData();
        long range = 99999999999l - 10000000000l;
        long insuaranceNumber = (long) (Math.random() * (range) + 10000000000l);
        setInsuranceNumber(insuaranceNumber);
    }
}
