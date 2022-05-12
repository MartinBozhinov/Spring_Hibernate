package com.example.onetooneuni;

import com.example.onetooneuni.entity.Instructor;
import com.example.onetooneuni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Instructor tempInstructor = new Instructor("Martin","Bozhinov", "bozhinkata@Gmail.com");
        InstructorDetail tempInstDetails = new InstructorDetail("youtube.com","outdoor training");
        tempInstructor.setInstructorDetail(tempInstDetails);
        try {
            session.beginTransaction();
            session.save(tempInstructor);

            int theId = 1;
            Instructor instructorToDelete = session.get(Instructor.class,theId);
             //will also delete associated "details"
            // because of CASCADING.ALL
            if (instructorToDelete != null){
               session.delete(instructorToDelete);
            }


            session.getTransaction().commit();
        }finally {
            factory.close();
        }


    }
}
