package pl.kielce.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="professor")
public class Professor extends Person{
 
    @Column(name="insurance_number")
    private long insuranceNumber;
    @Embedded
    private Car car;

//    @OneToMany(mappedBy = "professor")
//    private List<Course> listOfCourse;

    public Professor() {
    }

    public Professor(int insuranceNumber, Car car, List<Course> listOfCourse) {
        this.insuranceNumber = insuranceNumber;
        this.car = car;
//        this.listOfCourse = listOfCourse;
    }

    public Professor(String firstName, String lastName, Gender gender, Address addressInfo, String email, int phone, int insuranceNumber, Car car, List<Course> listOfCourse) {
        super(firstName, lastName, gender, addressInfo, email, phone);
        this.insuranceNumber = insuranceNumber;
        this.car = car;
//        this.listOfCourse = listOfCourse;
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

//    public List<Course> getListOfCourse() {
//        return listOfCourse;
//    }
//
//    public void setListOfCourse(List<Course> listOfCourse) {
//        this.listOfCourse = listOfCourse;
//    }

    @Override
    public String toString(){
        return "Proffesor{" +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", car='" + car + '\'' + //vehicle.toString() or vehicle.getVehicleId()
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
//        boolean haveVehicle = generator.nextInt()%2 == 0;
//
//        //Does professor has a vehicle ? Let's random an answer
//        if(!haveVehicle){
//            setVehicle(null);
//        }else{
//            Vehicle vehicle1 = new Vehicle();
//            vehicle1.generateVehicleData();
//            setVehicle(vehicle1);
//        }

        Car car = new Car();
	    car.generateCarData();
	    setVehicle(car);
        
//        setListOfCourse(null);
    }
}
