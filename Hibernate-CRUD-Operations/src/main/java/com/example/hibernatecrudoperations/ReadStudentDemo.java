package com.example.hibernatecrudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudOperationsApplication.class, args);


        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Martin", "Bozhidarov", "marto@gmail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, tempStudent.getId());

            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }

    }


}
