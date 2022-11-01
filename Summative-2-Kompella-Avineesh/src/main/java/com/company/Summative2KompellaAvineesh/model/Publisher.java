package com.company.Summative2KompellaAvineesh.model;

import java.util.Objects;

public class Publisher {

    private int publisher_id;
    private String name;
    private String city;
    private String state;
    private String postal_code;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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
        return getPublisher_id() == publisher.getPublisher_id() &&
                getName().equals(publisher.getName()) &&
                getCity().equals(publisher.getCity()) &&
                getState().equals(publisher.getState()) &&
                getPostal_code().equals(publisher.getPostal_code()) &&
                getPhone().equals(publisher.getPhone()) &&
                getEmail().equals(publisher.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisher_id(), getName(), getCity(), getState(), getPostal_code(), getPhone(),
                getEmail());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
