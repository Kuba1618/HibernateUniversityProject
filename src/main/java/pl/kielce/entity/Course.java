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
    @OneToOne
    private Professor professor;
    @OneToOne
    private Student student;
    
    public Course() {
    
    }
   
    public Course(int courseId, String title, String room, Professor professor, Student student) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.room = room;
		this.professor = professor;
		this.student = student;
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

    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void generateCourseData()
    {
        Random generator = new Random();
        Faker faker = new Faker(new Locale("pl-PL"));
        float roomNumber = Math.round((1.0F + generator.nextFloat() * (5.4F - 1.0F)) * 100.0F) / 100.0F;
        setTitle(faker.educator().course());
        String buildings = "ABCD";
        setRoom(roomNumber + " "+ buildings.charAt(generator.nextInt(buildings.length())));
    }
}
