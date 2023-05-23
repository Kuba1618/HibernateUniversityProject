package pl.kielce.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;
import java.util.Random;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int courseId;
    @Column(name="title")
    private String title;
    @Column(name="room")
    private String room;
    @ManyToOne
    private Professor professor;
    @OneToMany
    private List<Student> listOfStudents;

    public Course() {
    }

    public Course(String title, String room, Professor professor,List<Student> listOfStudents) {
        this.title = title;
        this.room = room;
        this.professor = professor;
        this.listOfStudents = listOfStudents;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", room='" + room + '\'' +
                ", professor='" + professor.toString() + '\'' +
                ", listOfStudents='" + listOfStudents.toString()+ '\'' +
                '}';
    }

    public void generateData()
    {
        Random generator = new Random();
        Faker faker = new Faker(new Locale("pl-PL"));
        float roomNumber = Math.round((1.0F + generator.nextFloat() * (5.4F - 1.0F)) * 100.0F) / 100.0F;
        setTitle(faker.educator().course());
        setRoom("D"+ "." + roomNumber);
        //setProfessor();
        //setListOfStudents();
    }
}
