package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.GetCpfUsuarioInterface;

public class GetUsuarioCpfUseCase implements GetCpfUsuarioInterface {
    private final UsuarioRepository repository;

    public GetUsuarioCpfUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Usuario execute(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new InvalidCpfException("Usuário não encontrado"));
    }
}
