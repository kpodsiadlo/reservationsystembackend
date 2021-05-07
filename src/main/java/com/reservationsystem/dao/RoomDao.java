package com.reservationsystem.dao;

import com.reservationsystem.entity.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class RoomDao {
    @PersistenceContext
    EntityManager entityManager;

    public Room create(Room room) {
        entityManager.persist(room);
        return room;
    }

    public Room read(Integer id) {
        Room room = entityManager.find(Room.class, id);
        return room;
    }

    public Room readRoomWithReservations(Integer id) {
        Query query = entityManager.createQuery("SELECT Room from Room room JOIN FETCH room" +
                ".reservations where room.id = :id", Room.class).setParameter("id", id);
        List resultList = query.getResultList();
        return (Room) resultList.get(0);
    }

    public Room update(Room room, Integer id) {
        Room roomToChange = entityManager.find(Room.class, id);
        roomToChange.setReservations(roomToChange.getReservations());
        return roomToChange;
    }

    public Boolean delete(Integer id) {
        Room roomToDelete = entityManager.find(Room.class, id);
        entityManager.remove(roomToDelete);
        return Boolean.TRUE;
    }

    public List<Room> findAll() {
        return (List<Room>) entityManager.createQuery("SELECT R FROM Room R").getResultList();
    }
}