package pl.kielce.entity;
import java.util.List;
import java.util.Random;

import javax.persistence.*;


@Entity
@Table (name="student")
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name="student_generator", sequenceName = "student_seq", allocationSize=1)
    @Column (name="id")
    private int id;
    @Column(name="grade_average")
    private float gradeAverage;
    @Column(name="employed")
    private boolean employed;
    @Embedded
    private List<Class> listOfClasses;

    public Student(){

    }

    public Student(float gradeAverage, boolean employed, List<Class> listOfClasses) {
        this.gradeAverage = gradeAverage;
        this.employed = employed;
        this.listOfClasses = listOfClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Class> getListOfClasses() {
        return listOfClasses;
    }

    public void setListOfClasses(List<Class> listOfClasses) {
        this.listOfClasses = listOfClasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                ", addressInfo='" + this.getAddressInfo().toString() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", gradeAverage='" + gradeAverage + '\'' +
                ", employed='" + employed + '\'' +
               // ", listOfClasses='" + listOfClasses.toString() + '\'' +
                '}';
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
        setListOfClasses(null);
    }

}

