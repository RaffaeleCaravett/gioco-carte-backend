package com.example.giocoCarte.classifica;

import com.example.giocoCarte.partita.Partita;
import com.example.giocoCarte.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.cfg.context.ParameterTarget;

import java.util.List;

@Entity
@Table(name="classifica")
@Getter
@Setter
public class Classifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "classifica")
    private List<Partita> partita;
}
