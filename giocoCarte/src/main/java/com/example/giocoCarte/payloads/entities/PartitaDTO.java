package com.example.giocoCarte.payloads.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PartitaDTO(
        @NotEmpty(message="Il punteggio non può essere vuoto")
        long punteggio,
        @NotNull(message="lo user_id non può essere null")
        Long user_id
) {
}
