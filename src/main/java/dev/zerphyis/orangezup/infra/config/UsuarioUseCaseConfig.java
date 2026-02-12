package dev.zerphyis.orangezup.infra.config;

import dev.zerphyis.orangezup.application.usecases.services.UsuarioService;
import dev.zerphyis.orangezup.application.usecases.usuarios.*;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioUseCaseConfig {

    @Bean
    public CreateUsuarioUseCase createUsuarioUseCase(UsuarioRepository repository) {
        return new CreateUsuarioUseCase(repository);
    }

    @Bean
    public UpdateUsuarioUseCase updateUsuarioUseCase(UsuarioRepository repository) {
        return new UpdateUsuarioUseCase(repository);
    }

    @Bean
    public DeleteUsuarioUseCase deleteUsuarioUseCase(UsuarioRepository repository) {
        return new DeleteUsuarioUseCase(repository);
    }

    @Bean
    public GetUsuarioCpfUseCase getUsuarioCpfUseCase(UsuarioRepository repository) {
        return new GetUsuarioCpfUseCase(repository);
    }

    @Bean
    public ListUsuarioUseCase listUsuarioUseCase(UsuarioRepository repository) {
        return new ListUsuarioUseCase(repository);
    }


    @Bean
    public UsuarioService usuarioService(CreateUsuarioUseCase createUseCase, UpdateUsuarioUseCase updateUseCase, DeleteUsuarioUseCase deleteUseCase, GetUsuarioCpfUseCase getByCpfUseCase, ListUsuarioUseCase listUseCase) {
        return new UsuarioService(createUseCase, updateUseCase, deleteUseCase, getByCpfUseCase, listUseCase);
    }
}
