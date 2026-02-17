package dev.zerphyis.orangezup.application.usecases.usuarios;

import dev.zerphyis.orangezup.application.dto.usuarios.CreateUsuarioRequest;
import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Cpf;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.exception.InvalidEmailException;
import dev.zerphyis.orangezup.domain.interfacecases.usuarios.CreateUsuarioInterface;

public class CreateUsuarioUseCase implements CreateUsuarioInterface {

    private final UsuarioRepository repository;

    public CreateUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioResponse execute(CreateUsuarioRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new InvalidEmailException("Email já cadastrado: " + request.email());
        }

        if (repository.existsByCpf(request.cpf())) {
            throw new InvalidCpfException("CPF já cadastrado: " + request.cpf());
        }

        Usuario usuario = new Usuario(
                request.nome(),
                new Email(request.email()),
                new Cpf(request.cpf()),
                request.dataNascimento()
        );

        Usuario saved = repository.save(usuario);

        return new UsuarioResponse(
                saved.getNome(),
                saved.getEmail().value(),
                saved.getCpf().value(),
                saved.getDataNascimento()
        );
    }

}
