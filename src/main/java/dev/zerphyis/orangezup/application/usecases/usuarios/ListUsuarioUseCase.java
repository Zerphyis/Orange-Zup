package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.ListUsuarioInterface;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsuarioUseCase implements ListUsuarioInterface {

    private final UsuarioRepository repository;

    public ListUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuarioResponse> execute() {
        return repository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponse(
                        usuario.getNome(),
                        usuario.getEmail().value(),
                        usuario.getCpf().value(),
                        usuario.getDataNascimento()
                ))
                .collect(Collectors.toList());
    }
}
