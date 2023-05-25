package pl.kielce.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="professor")
public class Professor extends Person{
 
    @Column(name="insurance_number")
    private long insuranceNumber;
//    @Embedded
//    private Vehicle vehicle;

    @OneToMany(mappedBy = "professor")
    private List<Course> listOfCourse;

    public Professor() {
    }

    public Professor(int insuranceNumber, Vehicle vehicleId, List<Course> listOfCourse) {
        this.insuranceNumber = insuranceNumber;
//        this.vehicle = vehicleId;
        this.listOfCourse = listOfCourse;
    }

    public Professor(String firstName, String lastName, Gender gender, Address addressInfo, String email, int phone, int insuranceNumber, Vehicle vehicleId, List<Course> listOfCourse) {
        super(firstName, lastName, gender, addressInfo, email, phone);
        this.insuranceNumber = insuranceNumber;
//        this.vehicle = vehicleId;
        this.listOfCourse = listOfCourse;
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicleId) {
//        this.vehicle = vehicleId;
//    }

    public List<Course> getListOfCourse() {
        return listOfCourse;
    }

    public void setListOfCourse(List<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }

    @Override
    public String toString(){
        return "Proffesor{" +
//                "professorId=" + professorId +
                ", insuranceNumber='" + insuranceNumber + '\'' +
//                ", vehicle='" + vehicle + '\'' + //vehicle.toString() or vehicle.getVehicleId()
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
        boolean haveVehicle = generator.nextInt()%2 == 0;

//        //Does professor has a vehicle ? Let's random an answer
//        if(!haveVehicle){
//            setVehicle(null);
//        }else{
//            Vehicle vehicle1 = new Vehicle();
//            vehicle1.generateVehicleData();
//            setVehicle(vehicle1);
//        }
//
        setListOfCourse(null);
    }
}
