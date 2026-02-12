package dev.zerphyis.orangezup.domain.interfacecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.UpdateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;

public interface UpdateVacinaInterface {
    VacinaResponse execute(UpdateVacinaRequest input);
}
