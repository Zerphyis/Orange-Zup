package dev.zerphyis.orangezup.domain.interfacecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface UpdateUsuarioInterface {
    Usuario execute(String cpf, UpdateUsuarioRequest request);
}
