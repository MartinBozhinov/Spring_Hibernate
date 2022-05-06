package com.example.hibernatecrudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;

import java.util.List;

public class EmployeeCRUDexe {
    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudOperationsApplication.class, args);


        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {


            Employee employee1 = new Employee("Martincho","BOzhinkata", "asdasd@abv.bg");
            Employee employee2 = new Employee("MartoParto","BOjkata", "asdasd@abv.bg");
            Employee employee3 = new Employee("Martinqka","Bozhinov", "wqrfqwf@abv.bg");
            Employee employee4 = new Employee("FOOOO","Bozhidarov", "asdzccz@abv.bg");

            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            session.save(employee4);
            session.getTransaction().commit();

            // READING
            session.beginTransaction();
            Employee firstEmployye = session.get(Employee.class,employee1.getId());
            System.out.println("First employee id is: " + firstEmployye);
            session.getTransaction().commit();
            // UPDATE
            session.beginTransaction();
            firstEmployye.setFirstName("Bozhinoooviq");
            session.createQuery("UPDATE Employee set firstName='BOZHINKATA'").executeUpdate();
            session.getTransaction().commit();
            //DELETE
            session.beginTransaction();
            session.createQuery("DELETE Employee as e WHERE e.id=3").executeUpdate();
            session.getTransaction().commit();

        }finally {
            factory.close();
        }

    }
}