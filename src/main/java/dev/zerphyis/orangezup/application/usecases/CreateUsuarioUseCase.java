package dev.zerphyis.orangezup.application.usecases;

import dev.zerphyis.orangezup.application.dto.CreateUsuarioRequest;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Cpf;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;
import dev.zerphyis.orangezup.domain.exception.InvalidEmailException;
import dev.zerphyis.orangezup.domain.interfacecases.CreateUsuarioInterface;

public class CreateUsuarioUseCase implements CreateUsuarioInterface {

    private final UsuarioRepository repository;

    public CreateUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario execute(CreateUsuarioRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new InvalidEmailException("Email já cadastrado");
        }

        if (repository.existsByCpf(request.cpf())) {
            throw new InvalidCpfException("CPF já cadastrado");
        }

        Usuario usuario = new Usuario(
                request.nome(),
                new Email(request.email()),
                new Cpf(request.cpf()),
                request.dataNascimento()
        );

        return repository.save(usuario);
    }
}
