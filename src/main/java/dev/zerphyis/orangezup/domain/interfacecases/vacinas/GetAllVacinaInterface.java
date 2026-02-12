package dev.zerphyis.orangezup.domain.interfacecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;

import java.util.List;

public interface GetAllVacinaInterface {
    List<VacinaResponse> execute();
}
