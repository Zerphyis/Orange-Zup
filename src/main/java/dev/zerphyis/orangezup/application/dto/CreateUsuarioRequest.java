package dev.zerphyis.orangezup.application.dto;

import java.time.LocalDate;

public record CreateUsuarioRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
}
