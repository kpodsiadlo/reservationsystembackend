package com.reservationsystem.dao;

import com.reservationsystem.dto.FullUserDto;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.Room;
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

//    public FullUserDto getFullUser(Integer id){
//        FullUserDto fullUser = new FullUserDto();
//        User user = entityManager.find(User.class, 1);
//        Query query = entityManager.createQuery(
//                "From Reservation r where r.user.id = ?1",
//                Reservation.class)
//                .setParameter(1, id);
//        List<Reservation> reservationList = query.getResultList();
////        for (Reservation reservation : reservationList) {
////            entityManager.createQuery()
//        return fullUser;
//    }

//    public User read(Integer id) {
//        User user = entityManager.find(User.class, 1);
//        boolean contains = entityManager.contains(user);
//        System.out.println(contains);
//        List<Reservation> reservations = user.getReservations();
//        contains = entityManager.contains(user);
//        System.out.println(contains);
//        return user;
//
//    }

//    public User read(Integer id) {
//        Query nativeQuery = entityManager.
//                createNativeQuery(
// "select * from User LEFT JOIN Reservation as reservation on user_id = " +
// "reservation.user_id LEFT JOIN Room as room on reservation.room_id = room.id WHERE " +
//         "User_id = 1");
//        Object singleResult = nativeQuery.getSingleResult();
//        return (User) singleResult;
//    }

//    public User read(Integer id) {
//        Query query = entityManager.createQuery("select u from User u " +
//                "join fetch u.reservations r " +
//                "where u.id = :id");
//        query.setParameter("id", id);
//        Object singleResult = query.getSingleResult();
//        return (User) singleResult;
//    }

//    public FullUserDto readFullUser(Integer id) {
//        Query query = entityManager.createQuery("from User user " +
//                "left join user.reservations reservations " +
//                "left join reservations.room room " +
//                "where user.id = :id")
//                .setParameter("id", id);
//        List resultList = query.getResultList();
//        return new FullUserDto();
//    }

    public FullUserDto readFullUser(Integer id) {
        Query query = entityManager.createQuery("from User user " +
                "join fetch user.reservations reservations " +
//                "join fetch reservations.room room " +
                "where user.id = :id", User.class)
                .setParameter("id", id);
        List resultList = query.getResultList();
        User retrievedUser = (User) resultList.get(0);
        FullUserDto fullUserDto = UserMapper.toFullUserDto(retrievedUser);
        return fullUserDto;
    }

//    public User read(Integer id) {
//        User user = entityManager.find(User.class, id);
//        user.getReservations();
//        return user;
//    }

    public User read(Integer id){
        User user = entityManager.find(User.class, id);
        Query query = entityManager.createQuery(
                "From Reservation r where r.user = :id");
        query.setParameter("id", user.getId());
        List resultList = query.getResultList();
        user.setReservations(resultList);
        return user;
    }

    public User update(User user, Integer id) {
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