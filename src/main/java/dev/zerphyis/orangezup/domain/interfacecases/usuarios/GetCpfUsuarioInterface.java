package dev.zerphyis.orangezup.domain.interfacecases.usuarios;

import dev.zerphyis.orangezup.domain.entities.Usuario;

public interface GetCpfUsuarioInterface {
    Usuario execute(String cpf);
}
