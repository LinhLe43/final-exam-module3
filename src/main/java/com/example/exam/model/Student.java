package com.example.exam.model;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String address;
    private String phoneNumber;
    private String email;
    private ClassRoom classRoom;

    public Student(int id, String name, String dob, String address, String phoneNumber, String email, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(String name, String dob, String address, String phoneNumber, String email, ClassRoom classRoom) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
