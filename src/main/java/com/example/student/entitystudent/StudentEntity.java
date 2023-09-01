package com.example.student.entitystudent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class StudentEntity {
    @Id
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentEntity() {
    }

    private String address;

    public StudentEntity(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}


