package com.reservationsystem.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Reservation {

    @GeneratedValue
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
