package ru.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class HibernameConfig {
    private static SessionFactory factory;
    private Session currentSession;
    private Transaction currentTransaction;
    private Session session;

    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure("config/hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
        return factory;
    }

    public static void shutdown(){
        factory.close();
    }

    public static void prepareDatabase(){
        Session  session = factory.getCurrentSession();
        try{
            String sql = Files.lines(Paths.get("script.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           session.close();
        }
    }

}
