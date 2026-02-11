package dev.zerphyis.orangezup.application.dto.usuarios;

import java.time.LocalDate;

public record CreateUsuarioRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
}
