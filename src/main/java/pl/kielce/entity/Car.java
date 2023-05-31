package pl.kielce.entity;

import com.github.javafaker.Faker;
import javax.persistence.*;

import java.util.Locale;
import java.util.Random;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{
    
    @Column(name="color")
    private String color;
    @Column(name="mile_age")
    private float mileAge;
    @Enumerated(EnumType.STRING)
    private TypeOfCarBody typeOfCarBody;
    @Column(name="engine_size")
    private float engineSize;
    @OneToOne
    private Professor professor; 

    public Car(){

    }

    public Car(boolean singleTrack, String licensePlate,String color, float mileAge, TypeOfCarBody bodyType, float engineSize) {
        super(singleTrack,licensePlate);
        this.color = color;
        this.mileAge = mileAge;
        this.typeOfCarBody = bodyType;
        this.engineSize = engineSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getMileAge() {
        return mileAge;
    }

    public void setMileAge(float mileAge) {
        this.mileAge = mileAge;
    }

    public TypeOfCarBody getBodyType() {
        return typeOfCarBody;
    }

    public void setBodyType(TypeOfCarBody bodyType) {
        this.typeOfCarBody = bodyType;
    }

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }
    
    public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
    public String toString() {
        return "Car{" +
                ", licensePlate='" + this.getLicensePlate() + '\'' +
                ", singleTrack='" + this.isSingleTrack() + '\'' +
                ", color='" + color + '\'' +
                ", mileAge='" + mileAge + '\'' +
                ", fuel='" + typeOfCarBody + '\'' +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }

    public void generateCarData()
    {
        Random generator = new Random();
        Faker faker = new Faker(new Locale("pl-PL"));

        generateVehicleData();
        setColor(faker.color().name());
        float mileAge = 35.000F + generator.nextFloat() * (450.000F - 35.000F);
        setMileAge(mileAge);
        setBodyType(TypeOfCarBody.randomBodyType());

        float randomEngineSize = Math.round((0.8F + generator.nextFloat() * (2.4F - 0.8F)) * 10.0F) / 10.0F;

        setEngineSize(randomEngineSize);
    }

}
