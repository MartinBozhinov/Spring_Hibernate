package spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Trainer trainer = context.getBean("myTrainer",Trainer.class);

       // System.out.println(theCoach.getDailyWorkout());
        System.out.println(trainer.train());

        context.close();


    }
}
