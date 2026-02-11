package dev.zerphyis.orangezup.application.dto.vacina;

import dev.zerphyis.orangezup.domain.entities.vo.Email;

import java.time.LocalDate;

public record VacinaResponse(String nomeVacina , Email emailUsuario, LocalDate dataAplicacao ) {
}
