package dev.zerphyis.orangezup.domain.interfacecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.CreateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface CreateUsuarioInterface {
    Usuario execute(CreateUsuarioRequest request);
}
