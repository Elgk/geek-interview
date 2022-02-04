package ru.geekbrains.hibernate;

import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      //  HibernameConfig config = new HibernameConfig();
        SessionFactory sessionFactory = HibernameConfig.getSessionFactory();
        StudentDao dao = new StudentDao(sessionFactory);
        try {
           HibernameConfig.prepareDatabase();

            List<Student> list = dao.findAll();
            System.out.println(list);

            Student newStudent = new Student(4L,"John", 5 );
            dao.persist(newStudent);
            Student student = dao.findById(1L);
            student.setMark(7);
            dao.update(student);

            Student student2 = dao.findById(2L);
            dao.delete(student2);

            List<Student> list1 = dao.findAll();
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernameConfig.shutdown();
        }

    }
}
