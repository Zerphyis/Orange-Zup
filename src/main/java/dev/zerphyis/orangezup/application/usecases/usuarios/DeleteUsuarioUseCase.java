package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.DeleteUsuarioInterface;

public class DeleteUsuarioUseCase implements DeleteUsuarioInterface {

    private final UsuarioRepository repository;

    public DeleteUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String cpf) {
        if (!repository.existsByCpf(cpf)) {
            throw new InvalidCpfException("Usuário com CPF " + cpf + " não encontrado");
        }

        repository.deleteByCpf(cpf);
    }

}
