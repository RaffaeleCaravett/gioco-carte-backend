package com.example.giocoCarte.partita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartitaRepository extends JpaRepository<Partita,Long> {
    List<Partita> findByUser_Id(long id);
}
