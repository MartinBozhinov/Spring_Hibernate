package com.example.hibernatecrudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;

public class DeleteStudent {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudOperationsApplication.class, args);


        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Martin", "Bozhidarov", "marto@gmail.com");
            Student tempStudent1 = new Student("Martinchooo", "Bozhidaroviq", "mart1313@gmail.com");
            Student tempStudent2 = new Student("Martonkata", "Bozhinoviq", "mart221@gmail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();


            session.createQuery("DELETE FROM Student as s where s.id=1").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }
}
