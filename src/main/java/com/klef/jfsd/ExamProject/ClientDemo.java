package com.klef.jfsd.ExamProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Load Hibernate Configuration
    	  SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
          Session session = factory.openSession();

          // Begin Transaction
          session.beginTransaction();

          // Creating a generic Device
          Device device = new Device();
          device.setName("Generic Device");
          device.setPrice(200);

          // Creating a Smartphone
          SmartPhone smartphone = new SmartPhone();
          smartphone.setName("iPhone 15");
          smartphone.setPrice(1200);
          smartphone.setOs("iOS");

          // Creating a Tablet
          Tablet tablet = new Tablet();
          tablet.setName("Galaxy Tab S8");
          tablet.setPrice(800);
          tablet.setScreenSize(11.0);

          // Persisting the entities
          session.save(device);
          session.save(smartphone);
          session.save(tablet);

          // Commit Transaction
          session.getTransaction().commit();
          session.close();
          factory.close();

          System.out.println("Records saved successfully!");
    }
}
