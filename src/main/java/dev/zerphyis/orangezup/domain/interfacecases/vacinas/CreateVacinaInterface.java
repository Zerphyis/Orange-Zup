package dev.zerphyis.orangezup.domain.interfacecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.CreateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;

public interface CreateVacinaInterface {
    VacinaResponse execute(CreateVacinaRequest input);
}
