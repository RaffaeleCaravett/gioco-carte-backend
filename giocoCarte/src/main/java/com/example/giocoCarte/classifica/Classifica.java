package com.example.giocoCarte.classifica;

import com.example.giocoCarte.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private List<User> user;
}
