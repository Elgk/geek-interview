package ru.geekbrains.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OtherStudentDao {
    private final EntityManagerFactory emFactory;

    public OtherStudentDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

//    public List<Student> findAll(){
//        EntityManager em = emFactory.createEntityManager();
//        try{
//            return em.createNamedQuery("findAllStudents", Student.class).getResultList();
//        }
//        finally {
//            em.close();
//        }
//    }

/*    public Optional<Student> findById(Long id){
        EntityManager em = emFactory.createEntityManager();
        try {
            return Optional.ofNullable(em.find(Student.class,id));
        }
        finally {
            em.close();
        }
    }*/
    private <T> T executedWithEntityManager(Function<EntityManager, T> function){
        EntityManager em = emFactory.createEntityManager();
        try{
            return function.apply(em);
        }
        finally {
            em.close();
        }
    }

    private void  executedInTransaction(Consumer<EntityManager> consumer){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            consumer.accept(em);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public List<Student> findAll(){
        return executedWithEntityManager(em -> em.createNamedQuery("findAllStudents", Student.class).getResultList());
    }

    public Optional<Student> findById(Long id){
        return executedWithEntityManager(em -> Optional.ofNullable(em.find(Student.class, id)));
    }

    public void save(Student student){
        if (student.getId() == null){
            executedInTransaction(em -> em.persist(student));
        }else {
            executedInTransaction(em -> em.merge(student));
        }
    }

    public void delete(Student student){
        executedInTransaction(em -> em.remove(student));
    }
}
