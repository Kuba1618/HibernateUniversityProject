package pl.kielce.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity(name="professor")
public class Professor extends Person{
    @Id
    @GeneratedValue
    private int professorId;
    @Column(name="insurance_number")
    private long insuranceNumber;
    @Embedded
    private Vehicle vehicle;

    @OneToMany(mappedBy = "professor")
    private List<Course> listOfCourse;

    public Professor() {
    }

    public Professor(int insuranceNumber, Vehicle vehicleId, List<Course> listOfCourse) {
        this.insuranceNumber = insuranceNumber;
        this.vehicle = vehicleId;
        this.listOfCourse = listOfCourse;
    }

    public Professor(String firstName, String lastName, Gender gender, Address addressInfo, String email, int phone, int insuranceNumber, Vehicle vehicleId, List<Course> listOfCourse) {
        super(firstName, lastName, gender, addressInfo, email, phone);
        this.insuranceNumber = insuranceNumber;
        this.vehicle = vehicleId;
        this.listOfCourse = listOfCourse;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicleId) {
        this.vehicle = vehicleId;
    }

    public List<Course> getListOfCourse() {
        return listOfCourse;
    }

    public void setListOfCourse(List<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }

    @Override
    public String toString(){
        return "Proffesor{" +
                "professorId=" + professorId +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", vehicle='" + vehicle + '\'' + //vehicle.toString() or vehicle.getVehicleId()
                ", listOfCourse='" + " " + '\'' +
                '}';
    }

    public void generateProfessorData()
    {
        Random generator = new Random();

        generatePersonData();
       // long randInsuaranceNumber = generator.nextLong(99999999999l - 10000000000l + 1);
        //setInsuranceNumber(randInsuaranceNumber);
        boolean haveVehicle = generator.nextInt()%2 == 0;

        //Does professor has a vehicle ? Let's random an answer
        if(!haveVehicle){
            setVehicle(null);
        }else{
            Vehicle vehicle1 = new Vehicle();
            vehicle1.generateVehicleData();
            setVehicle(vehicle1);
        }

        setListOfCourse(null);
    }
}
