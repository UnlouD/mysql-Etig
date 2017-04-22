package com.rr.controller;

import javafx.beans.property.*;

public class GetSetStudent {

    private SimpleLongProperty id;
    private SimpleIntegerProperty firstname;
    private SimpleStringProperty surname;
    private SimpleStringProperty gender;
    private SimpleStringProperty birthday;
    private SimpleStringProperty address;
    private SimpleStringProperty phone;
    private SimpleStringProperty city;

    public GetSetStudent(SimpleLongProperty id, SimpleIntegerProperty firstname, SimpleStringProperty surname, SimpleStringProperty gender, SimpleStringProperty birthday, SimpleStringProperty address, SimpleStringProperty phone) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public GetSetStudent(SimpleLongProperty id, SimpleIntegerProperty firstname, SimpleStringProperty surname, SimpleStringProperty gender, SimpleStringProperty birthday, SimpleStringProperty address, SimpleStringProperty phone, SimpleStringProperty city) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public int getFirstname() {
        return firstname.get();
    }

    public SimpleIntegerProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(int firstname) {
        this.firstname.set(firstname);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }
}
