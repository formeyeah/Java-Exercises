package ir.freeland.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ir.freeland.hibernate.model.User;

import java.util.List;

public class HibernateExample {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create a new user
        User newUser = new User("john_doe", "john@example.com");

        // Save the user
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(newUser);
            transaction.commit();
        }

        // Read users
        try (Session session = sessionFactory.openSession()) {
            List<User> users = session.createQuery("from User", User.class).list();
            for (User user : users) {
                System.out.println(user.getUsername() + " - " + user.getEmail());
            }
        }

        // Update user
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User userToUpdate = session.get(User.class, newUser.getId());
            userToUpdate.setEmail("john.doe@example.com");
            transaction.commit();
        }

        // Delete user
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User userToDelete = session.get(User.class, newUser.getId());
            session.remove(userToDelete);
            transaction.commit();
        }

        // Close SessionFactory
        sessionFactory.close();
    }
}