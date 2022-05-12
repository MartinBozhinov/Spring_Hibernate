package com.example.eagerandlazyloading;

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


            int theIdThatNotExist = 2999;

            Instructor instructorNotExist = session.get(Instructor.class,theIdThatNotExist);

            session.get(Instructor.class,theIdThatNotExist);
            

             //will also delete associated "details"
            // because of CASCADING.ALL
            if (instructorToDelete != null){
               session.delete(instructorToDelete);
            }
            session.getTransaction().commit();


        }catch (Exception exc){
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
