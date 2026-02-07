package dev.zerphyis.orangezup.domain.entities.vo;

import dev.zerphyis.orangezup.domain.exception.InvalidEmailException;

public record Email(String value) {

    public Email {
        if (value == null) {
            throw new InvalidEmailException("Email é obrigatório.");
        }

        String normalized = value.trim().toLowerCase();

        if (!normalized.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new InvalidEmailException("Formato de email inválido.");
        }

        value = normalized;
    }
}
