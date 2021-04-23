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
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String surname;
    private UserRole role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
