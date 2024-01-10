package com.example.giocoCarte.partita;

import com.example.giocoCarte.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partita")
@Getter
@Setter
public class Partita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long punteggio;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
