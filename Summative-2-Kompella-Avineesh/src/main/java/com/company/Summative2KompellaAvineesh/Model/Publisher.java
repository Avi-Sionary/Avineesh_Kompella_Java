package com.company.Summative2KompellaAvineesh.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="publisher")
public class Publisher implements Serializable{

    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisher_id;
    private String name;
    private String city;
    private String state;
    private String street;
    private String postalCode;
    private String phone;
    private String email;

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return getPublisher_id() == publisher.getPublisher_id() && getName().equals(publisher.getName()) && getCity().equals(publisher.getCity()) && getState().equals(publisher.getState()) && getStreet().equals(publisher.getStreet()) && getPostalCode().equals(publisher.getPostalCode()) && getPhone().equals(publisher.getPhone()) && getEmail().equals(publisher.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisher_id(), getName(), getCity(), getState(), getStreet(), getPostalCode(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
