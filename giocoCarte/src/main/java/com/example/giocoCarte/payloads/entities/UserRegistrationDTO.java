package com.example.giocoCarte.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

public record UserRegistrationDTO(
        long id,

        @NotEmpty(message = "L'email è un campo obbligatorio!")
        String email,
        @NotEmpty(message = "La password è un campo obbligatorio!")
        String password,
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        String nome,
        @NotEmpty(message = "Lo username è un campo obbligatorio!")
        String username
){}
