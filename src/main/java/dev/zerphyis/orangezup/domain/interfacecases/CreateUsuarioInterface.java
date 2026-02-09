package dev.zerphyis.orangezup.domain.interfacecases;

import dev.zerphyis.orangezup.application.dto.CreateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface CreateUsuarioInterface {
    Usuario execute(CreateUsuarioRequest request);
}
