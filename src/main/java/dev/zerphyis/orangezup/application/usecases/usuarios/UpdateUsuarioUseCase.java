package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.EmailAlreadyExistsException;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.UpdateUsuarioInterface;

public class UpdateUsuarioUseCase implements UpdateUsuarioInterface {

    private final UsuarioRepository repository;

    public UpdateUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioResponse execute(String cpf, UpdateUsuarioRequest request) {

        Usuario usuario = repository.findByCpf(cpf)
                .orElseThrow(() ->
                        new InvalidCpfException("Usuário não encontrado"));

        if (!usuario.getEmail().value().equals(request.email())
                && repository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }

        usuario.setNome(request.nome());
        usuario.setEmail(new Email(request.email()));
        usuario.setDataNascimento(request.dataNascimento());

        Usuario updated = repository.save(usuario);

        return new UsuarioResponse(
                updated.getNome(),
                updated.getEmail().value(),
                updated.getCpf().value(),
                updated.getDataNascimento()
        );
    }
}



