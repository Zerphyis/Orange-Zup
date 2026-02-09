package dev.zerphyis.orangezup.infra.config;

import dev.zerphyis.orangezup.application.usecases.*;
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
}
