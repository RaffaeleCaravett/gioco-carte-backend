package com.example.giocoCarte.carte;

import com.example.giocoCarte.enums.CartType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cards")
@Getter
@Setter
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int value;
    private String color;
    private CartType cartType;
}
