package pl.kielce.entity;

import java.util.Random;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Motorcycle")
public class Motorcycle extends Vehicle{

    @Column(name="engine_size")
    private int engineSize;
    @Column(name="mile_age")
    private float mileAge;

    public Motorcycle(){

    }

    public Motorcycle(boolean singleTrack, String licensePlate, int engineSize) {
        super(singleTrack, licensePlate);
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public float getMileAge() {
        return mileAge;
    }

    public void setMileAge(float mileAge) {
        this.mileAge = mileAge;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                ", licensePlate='" + this.getLicensePlate() + '\'' +
                ", singleTrack='" + this.isSingleTrack() + '\'' +
                ", engineSize='" + engineSize + '\'' +
                ", mileAge='" + mileAge + '\'' +
                '}';
    }

    public void generateData()
    {
        Random generator = new Random();
        //Faker faker = new Faker(new Locale("pl-PL"));

        generateVehicleData();
        int randomEngineSize = generator.nextInt(1795 - 50) + 50;
        setEngineSize(randomEngineSize);
        float randomMileAge = generator.nextFloat() * (35.000F - 5.000F) + 5.000F;
        setMileAge(randomMileAge);
    }
}
