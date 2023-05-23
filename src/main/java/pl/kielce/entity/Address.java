package pl.kielce.entity;

import java.util.Locale;

import javax.persistence.*;
import com.github.javafaker.Faker;

@Embeddable
public class Address {
    
    @Column (name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="zip_code")
    private String zipCode;

    public Address() {
    }

    public Address(String country, String city, String street, String zipCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressInformation{" +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public void generateAddressData() {
        Faker faker = new Faker(new Locale("pl-PL"));

        setCountry(faker.address().country());
        setCity(faker.address().cityName());
        setStreet(faker.address().streetName());
        setZipCode(faker.address().zipCode());
    }
}
