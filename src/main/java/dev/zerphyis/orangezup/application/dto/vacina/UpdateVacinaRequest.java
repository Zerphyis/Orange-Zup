package dev.zerphyis.orangezup.application.dto.vacina;

import java.time.LocalDate;

public record UpdateVacinaRequest(Long id, String nomeVacina, LocalDate dataAplicacao) {
}
