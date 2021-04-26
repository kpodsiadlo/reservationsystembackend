package com.reservationsystem.dao;

import com.reservationsystem.entity.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class RoomDao {
    @PersistenceContext
    EntityManager entityManager;

    public Room create (Room room) {
        entityManager.persist(room);
        return room;
    }

    public Room read(Integer id) {
        Room room = entityManager.find(Room.class, id);
        return room;
    }

    public Room update (Room room, Integer id) {
        Room roomToChange = entityManager.find(Room.class, id);
        roomToChange.setReservations(roomToChange.getReservations());
        return roomToChange;
    }

    public Boolean delete(Room room, Integer id) {
        Room roomToDelete = entityManager.find(Room.class, id);
        entityManager.remove(roomToDelete);
        return Boolean.TRUE;
    }

    public List<Room> findAll() {
        return (List<Room>) entityManager.createQuery("SELECT R FROM Room R").getResultList();
    }
}