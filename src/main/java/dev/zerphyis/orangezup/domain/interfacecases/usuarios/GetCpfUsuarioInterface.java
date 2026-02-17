package dev.zerphyis.orangezup.domain.interfacecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface GetCpfUsuarioInterface {
    UsuarioResponse execute(String cpf);
}
