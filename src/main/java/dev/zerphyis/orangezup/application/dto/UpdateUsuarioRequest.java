package dev.zerphyis.orangezup.application.dto;

import java.time.LocalDate;

public record UpdateUsuarioRequest(String nome, String email, LocalDate dataNascimento)  {
}
