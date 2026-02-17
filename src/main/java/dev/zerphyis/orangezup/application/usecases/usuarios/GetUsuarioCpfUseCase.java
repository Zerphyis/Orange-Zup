package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
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
    public UsuarioResponse execute(String cpf) {
        var usuario = repository.findByCpf(cpf)
                .orElseThrow(() -> new InvalidCpfException("Usuário com CPF " + cpf + " não encontrado"));

        return new UsuarioResponse(
                usuario.getNome(),
                usuario.getEmail().value(),
                usuario.getCpf().value(),
                usuario.getDataNascimento()
        );
    }
}
