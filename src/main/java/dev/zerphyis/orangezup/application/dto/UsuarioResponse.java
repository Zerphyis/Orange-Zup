package dev.zerphyis.orangezup.application.dto;

import java.time.LocalDate;

public record UsuarioResponse(String nome,
                              String email,
                              String cpf,
                              LocalDate dataNascimento) {
}
