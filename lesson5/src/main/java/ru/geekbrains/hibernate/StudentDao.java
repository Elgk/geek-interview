package ru.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class StudentDao {
    private Session currentSession;
    private Transaction currentTransaction;
    private final SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.getCurrentSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction(){
        currentSession = sessionFactory.getCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeSession(){
        currentSession.close();
    }

    public void closeSessionWitnTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    public void persist(Student student){
        openCurrentSessionwithTransaction();
        currentSession.persist(student);
      //  currentSession.save(student);// save - вставка новой записи
        closeSessionWitnTransaction();
    }

    public void update(Student student){
        openCurrentSessionwithTransaction();
        currentSession.update(student);
        closeSessionWitnTransaction();
    }

    public void delete(Student student){
        openCurrentSessionwithTransaction();
        currentSession.delete(student);
        closeSessionWitnTransaction();
    }

    public Student findById(Long id){
        openCurrentSessionwithTransaction();
        Student student = currentSession.get(Student.class, id);
        closeSessionWitnTransaction();
        return  student;
    }

    public List<Student> findAll(){
       openCurrentSessionwithTransaction();
        List<Student> list = currentSession.createQuery("select a from Student  a", Student.class).getResultList();
        closeSessionWitnTransaction();
        return  list;
    }

}
