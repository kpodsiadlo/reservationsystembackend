package com.reservationsystem.dao;

import com.reservationsystem.entity.Reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDao {
    @PersistenceContext
    EntityManager entityManager;

    public Reservation create(Reservation reservation) {
        entityManager.persist(reservation);
        return reservation;
    }

    public Reservation read(Integer id) {
        Query query = entityManager.createQuery("Select R from Reservation R " +
                "JOIN FETCH R.room room WHERE r.id = :id");
        query.setParameter("id", id);
        return (Reservation) query.getSingleResult();
    }

    public Reservation update(Reservation reservation, Integer id) {
        Reservation reservationToChange = entityManager.find(Reservation.class, id);
        reservationToChange.setRoom(reservation.getRoom());
        reservationToChange.setReservationStart(reservation.getReservationStart());
        reservationToChange.setReservationEnd(reservation.getReservationStart());
        reservationToChange.setUser(reservation.getUser());
        return reservationToChange;
    }

    public Boolean delete(Integer id) {
        Reservation reservationToDelete = entityManager.find(Reservation.class, id);
        entityManager.remove(reservationToDelete);
        return Boolean.TRUE;
    }

    public List<Reservation> findAll() {
        return (List<Reservation>) entityManager.createQuery("SELECT R FROM Reservation R").getResultList();
    }
}
