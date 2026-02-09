package dev.zerphyis.orangezup.application.usecases;

import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.interfacecases.ListUsuarioInterface;

import java.util.List;

public class ListUsuarioUseCase  implements ListUsuarioInterface {
    private final UsuarioRepository repository;

    public ListUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }
   @Override
    public List<Usuario> execute() {
        return repository.findAll();
    }
}
