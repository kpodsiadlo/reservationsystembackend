package com.reservationsystem.dao;

import com.reservationsystem.dto.UserWithReservationsDto;
import com.reservationsystem.entity.User;
import com.reservationsystem.mapper.UserMapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;


    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public UserWithReservationsDto readUserWithReservations(Integer id) {
        Query query = entityManager.createQuery("from User user " +
                "join fetch user.reservations reservations " +
//                "join fetch reservations.room room " +
                "where user.id = :id", User.class)
                .setParameter("id", id);
        List resultList = query.getResultList();
        User retrievedUser = (User) resultList.get(0);
        UserWithReservationsDto userWithReservationsDto = UserMapper.toUserWithReservationsDto(retrievedUser);
        return userWithReservationsDto;
    }


    public User read(Integer id){
        User user = entityManager.find(User.class, id);
        return (user);
    }

    public User readEntity(Integer id){
        return entityManager.find(User.class, id);
    }

    public User update(User user, Integer id) {
        User userToChange = entityManager.find(User.class, id);
        userToChange.setFirstName(user.getFirstName());
        userToChange.setLastName(user.getLastName());
        return userToChange;
    }

    public Boolean delete(Integer id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
        return Boolean.TRUE;
    }

    public List<User> findAll() {
        return (List<User>) entityManager.createQuery("SELECT U FROM User U").getResultList();
    }
}