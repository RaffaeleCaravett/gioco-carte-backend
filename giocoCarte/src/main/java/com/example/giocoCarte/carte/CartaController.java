package com.example.giocoCarte.carte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carta")
public class CartaController {

    @Autowired
    CartaService cartaService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public List<Carta> findAll(){
        return cartaService.findAll();
    }
}
