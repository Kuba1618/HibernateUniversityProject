package pl.kielce.entity;
import java.util.Random;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int vehicleId;
    @Column(name="single_track")
    private boolean singleTrack;
    @Column(name="license_plate")
    private String licensePlate;

    public Vehicle() {
    }

    public Vehicle(boolean singleTrack, String licensePlate) {
        this.singleTrack = singleTrack;
        this.licensePlate = licensePlate;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public boolean isSingleTrack() {
        return singleTrack;
    }

    public void setSingleTrack(boolean singleTrack) {
        this.singleTrack = singleTrack;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", singleTrack='" + singleTrack + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public static String generatePlateLicense(int n)
    {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   // + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(alphabet.length() * Math.random());
            sb.append(alphabet.charAt(index));
        }

        return sb.toString();
    }

    public void generateVehicleData()
    {
        Random generator = new Random();

        boolean isSingleTrack = generator.nextInt() % 2 == 0;
        setSingleTrack(isSingleTrack);

        int licenseNumber = generator.nextInt((9999 - 1000) + 1)  + 1000;
        String licenseString = generatePlateLicense(3) + "-" + licenseNumber;
        setLicensePlate(licenseString);

    }

}







