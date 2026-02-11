package dev.zerphyis.orangezup.application.dto.usuarios;

import java.time.LocalDate;

public record UsuarioResponse(String nome,
                              String email,
                              String cpf,
                              LocalDate dataNascimento) {
}
