package com.example.giocoCarte.carte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    public List<Carta> findAll(){
        return cartaRepository.findAll();
    }


}
