package com.reservationsystem.dao;

import com.reservationsystem.model.User;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;


    public User create (User user) {
        entityManager.persist(user);
        return user;
    }

    public User read(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public User update (User user, Integer id) {
        User userToChange = entityManager.find(User.class, id);
        userToChange.setFirstName(user.getFirstName());
        userToChange.setSurname(user.getSurname());
        userToChange.setRole(user.getRole());
        userToChange.setReservations(userToChange.getReservations());
        return userToChange;
    }

    public Boolean delete(User user, Integer id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
        return Boolean.TRUE;
    }

    public List<User> findAll() {
        return (List<User>) entityManager.createQuery("SELECT U FROM User U").getResultList();
    }
}