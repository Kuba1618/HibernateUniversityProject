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
    private Fuel fuel;
    @Column(name="engine_size")
    private float engineSize;

    public Car(){

    }

    public Car(boolean singleTrack, String licensePlate,String color, float mileAge, Fuel fuel, float engineSize) {
        super(singleTrack,licensePlate);
        this.color = color;
        this.mileAge = mileAge;
        this.fuel = fuel;
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

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", licensePlate='" + this.getLicensePlate() + '\'' +
                ", singleTrack='" + this.isSingleTrack() + '\'' +
                ", color='" + color + '\'' +
                ", mileAge='" + mileAge + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }

    public void generateData()
    {
        Random generator = new Random();
        Faker faker = new Faker(new Locale("pl-PL"));

        generateVehicleData();
        setColor(faker.color().name());
        float mileAge = 35.000F + generator.nextFloat() * (450.000F - 35.000F);
        setMileAge(mileAge);
        setFuel(Fuel.randomFuel());

        float randomEngineSize = Math.round((0.8F + generator.nextFloat() * (2.4F - 0.8F)) * 10.0F) / 10.0F;

        setEngineSize(randomEngineSize);
    }
}
