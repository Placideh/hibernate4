package com.placideh.hibernate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student student=new Student();
    	student.setRollno(21172);
    	student.setName("Placideh");
    	student.setMarks(13);
    	Laptop laptop=new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	student.setLaptop(laptop);
    	
    	Configuration config =new Configuration().configure()
						.addAnnotatedClass(Student.class)
						.addAnnotatedClass(Laptop.class);
    	
    	SessionFactory sf=config.buildSessionFactory();
    	Session session=sf.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.save(laptop);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}
