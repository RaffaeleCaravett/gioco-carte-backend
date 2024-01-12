package com.example.giocoCarte.payloads.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PartitaDTO(
        @NotNull(message="Il punteggio non può essere vuoto")
        long punteggio,
        @NotNull(message="I minuti non possono essere vuoti")
        int minuti,
        @NotNull(message="Il punteggio non possono essere vuoti")
        int secondi,
        @NotNull(message="lo user_id non può essere null")
        Long user_id
) {
}
