package ru.geekbrains.hibernate;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EntityManagerMain {
    public static void main(String[] args) {

        EntityManagerFactory emFactory = HibernameConfig.getEntityManagerFactory();
        OtherStudentDao dao = new OtherStudentDao(emFactory);
        try {

            List<Student> list = dao.findAll();
            System.out.println(list);

            Student newStudent = new Student("Kate",7);
            dao.save(newStudent);

            Student student = dao.findById(5L).orElseGet(null);
            if (student != null){
                student.setMark(1);
                student.setName("Bob");
                dao.save(student);
            }

            Student student2 = dao.findById(4L).orElseGet(null);
            if (student2 != null){
                dao.delete(student2);
            }

            List<Student> list1 = dao.findAll();
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emFactory.close();
        }

    }
}
