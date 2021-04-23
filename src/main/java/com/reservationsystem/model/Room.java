package com.reservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @GeneratedValue
    @Id
    private Integer id;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<Reservation> reservations;
}
