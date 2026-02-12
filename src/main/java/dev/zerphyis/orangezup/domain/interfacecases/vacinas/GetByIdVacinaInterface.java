package dev.zerphyis.orangezup.domain.interfacecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;

public interface GetByIdVacinaInterface {
    VacinaResponse execute(Long id);
}
