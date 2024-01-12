package com.example.giocoCarte.partita;

import com.example.giocoCarte.classifica.ClassificaRepository;
import com.example.giocoCarte.exceptions.NotFoundException;
import com.example.giocoCarte.payloads.entities.PartitaDTO;
import com.example.giocoCarte.payloads.entities.UserRegistrationDTO;
import com.example.giocoCarte.user.User;
import com.example.giocoCarte.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartitaService {
    @Autowired
    private PartitaRepository partitaRepository;
    @Autowired
    private ClassificaRepository classificaRepository;
    @Autowired
    private UserRepository userRepository;

    public long save(PartitaDTO partita) throws NotFoundException {
        Partita p = new Partita();

        p.setPunteggio(partita.punteggio());
        p.setMinuti(partita.minuti());
        p.setSecondi(partita.secondi());
        p.setUser(userRepository.findById(partita.user_id()).get());
        p.setClassifica(classificaRepository.findById(1L).get());
        partitaRepository.save(p);
        return p.getId();
    }
    public List<Partita> findByUserId(long id) throws NotFoundException {
        return partitaRepository.findByUser_Id(id);
    }

    public List<Partita> findAll() throws NotFoundException {
        return partitaRepository.findAll();
    }

  }
