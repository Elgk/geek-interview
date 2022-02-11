package ru.geekbrains.hibernate;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernameConfig.getSessionFactory();
        StudentDao dao = new StudentDao(sessionFactory);
        try {
          //  HibernameConfig.prepareDatabase();

            List<Student> list = dao.findAll();
            System.out.println(list);

            Student newStudent = new Student("John",7);
            dao.persist(newStudent);
            Student student = dao.findById(5L);
            student.setMark(3);
            student.setName("Mike");
            dao.update(student);
            Student student2 = dao.findById(6L);
            dao.delete(student2);
            List<Student> list1 = dao.findAll();
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            HibernameConfig.shutdown();
        }

    }
}
