package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.AbstractDao;
import com.dev.cinema.dao.UserDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User add(User user) {
        return super.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = super.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("select u from User u"
                    + " inner join fetch u.roles where u.email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find user by email " + email, e);
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        return super.getById(User.class, id);
    }
}
