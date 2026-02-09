package dev.zerphyis.orangezup.domain.interfacecases;

import dev.zerphyis.orangezup.application.dto.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface UpdateUsuarioInterface {
    Usuario execute(String cpf, UpdateUsuarioRequest request);
}
