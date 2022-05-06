package com.example.hibernatecrudoperations;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Student(String martin, String bozhidarov, String s) {
    }

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
