package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.UpdateUsuarioInterface;

public class UpdateUsuarioUseCase implements UpdateUsuarioInterface {

    private final UsuarioRepository repository;

    public UpdateUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Usuario execute(String cpf, UpdateUsuarioRequest request) {
        Usuario usuario = repository.findByCpf(cpf)
                .orElseThrow(() -> new InvalidCpfException("Usuário não encontrado"));

        Usuario usuarioAtualizado = new Usuario(
                request.nome(),
                new Email(request.email()),
                usuario.getCpf(),
                request.dataNascimento()
        );

        return repository.save(usuarioAtualizado);
    }
}
