package com.example.eagerandlazyloading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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
        session.beginTransaction();
        session.save(tempInstructor);
        session.close();

        try {
            session.beginTransaction();
            System.out.println("Instructor" + tempInstructor);

            System.out.println("Courses" + tempInstructor.getInstructorDetail());




        }catch (Exception exc){
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
