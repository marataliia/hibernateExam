package kg.db;

import kg.entities.Post;
import kg.entities.User;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDB {
    public static User create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }



    public static List<User> showUsersBySortingNames () {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User u ORDER BY u.userName asc", User.class).list();
        session.close();
        return users;
    }



}
