package dev.zerphyis.orangezup.domain.interfacecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.domain.entities.Usuario;

import java.util.List;

public interface ListUsuarioInterface {
    List<UsuarioResponse> execute();
}
