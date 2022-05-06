package com.example.hibernatecrudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateCrudOperationsApplication {

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
        } finally {
            factory.close();
        }

    }
}
