package ir.freeland.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ir.freeland.hibernate.model.User;

public class HibernateNewSyntaxExample {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create a new user
        User newUser = new User("john_doe", "john@example.com");

        // Save the user
        sessionFactory.inTransaction( session -> {
        	session.persist(newUser);
        });
        

        // Read users
        sessionFactory.inTransaction( session -> {             
            session
            	.createQuery("from User", User.class)
            	.getResultList()
            	.forEach( t -> System.out.println(t.getUsername() + " - " + t.getEmail()) );
        });

        
        // Update user
        sessionFactory.inTransaction( session -> {
            User userToUpdate = session.get(User.class, newUser.getId());
            userToUpdate.setEmail("john.doe@example.com");
        });
        
        // Delete user
        sessionFactory.inTransaction( session -> {
            User userToDelete = session.get(User.class, newUser.getId());
            session.remove(userToDelete);
        });
        

        // Close SessionFactory
        sessionFactory.close();
    }
}