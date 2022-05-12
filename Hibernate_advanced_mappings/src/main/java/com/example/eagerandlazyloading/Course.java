package com.example.eagerandlazyloading;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String courseDetail;
    private Instructor instructor;


    public Course() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   @Column(name = "course_detail")
    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }
     @ManyToOne
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
