package pl.kielce.entity;

import java.util.Locale;

import javax.persistence.*;

import com.github.javafaker.Faker;

@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue
    private int personId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address addressInfo;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private int phone;

    public Person() {
    }

    public Person(String firstName, String lastName, Gender gender, Address addressInfo, String email, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.addressInfo = addressInfo;
        this.email = email;
        this.phone = phone;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(Address addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", addressInfo='" + addressInfo.toString() + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void generatePersonData()
    {
        Faker faker = new Faker(new Locale("pl-PL"));

        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setGender(Gender.randomGender());
        Address addressInfo = new Address();
        addressInfo.generateAddressData();
        setAddressInfo(addressInfo);
        setEmail(firstName.toLowerCase() +"."+ lastName.toLowerCase() +"@gmail.com");
        setPhone(Integer.valueOf(faker.phoneNumber().subscriberNumber(9) + ""));
    }

}
