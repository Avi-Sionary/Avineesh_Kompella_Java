package com.company.CustomerRecord.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customerrecord")
public class CustomerRecord implements Serializable {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String address_1;
    private String address_2;
    private String city;
    private String state;
    private int postalCode;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRecord customerRecord = (CustomerRecord) o;
        return getId() == customerRecord.getId() &&
                getPostalCode() == customerRecord.getPostalCode() &&
                Objects.equals(getFirstName(), customerRecord.getFirstName()) &&
                Objects.equals(getLastName(), customerRecord.getLastName()) &&
                Objects.equals(getEmail(), customerRecord.getEmail()) &&
                Objects.equals(getCompany(), customerRecord.getCompany()) &&
                Objects.equals(getPhone(), customerRecord.getPhone()) &&
                Objects.equals(getAddress_1(), customerRecord.getAddress_1()) &&
                Objects.equals(getAddress_2(), customerRecord.getAddress_2()) &&
                Objects.equals(getCity(), customerRecord.getCity()) &&
                Objects.equals(getState(), customerRecord.getState()) &&
                Objects.equals(getCountry(), customerRecord.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone(), getAddress_1(), getAddress_2(), getCity(), getState(), getPostalCode(), getCountry());
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}
