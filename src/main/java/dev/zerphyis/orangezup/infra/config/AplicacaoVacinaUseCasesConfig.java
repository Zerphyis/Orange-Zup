package dev.zerphyis.orangezup.infra.config;

import dev.zerphyis.orangezup.application.usecases.services.AplicacaoVacinaService;
import dev.zerphyis.orangezup.application.usecases.vacinas.*;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicacaoVacinaUseCasesConfig {

    @Bean
    public CreateVacinaUseCase createAplicacaoVacinaUseCase(
            AplicacaoVacinaRepository vacinaRepository,
            UsuarioRepository usuarioRepository
    ) {
        return new CreateVacinaUseCase(vacinaRepository, usuarioRepository);
    }

    @Bean
    public UpdateVacinaUseCase updateVacinaUseCase(
            AplicacaoVacinaRepository vacinaRepository
    ) {
        return new UpdateVacinaUseCase(vacinaRepository);
    }

    @Bean
    public DeleteVacinaUseCase deleteAplicacaoVacinaUseCase(
            AplicacaoVacinaRepository vacinaRepository
    ) {
        return new DeleteVacinaUseCase(vacinaRepository);
    }

    @Bean
    public GetByIdVacinaUseCase getAplicacaoVacinaByIdUseCase(
            AplicacaoVacinaRepository vacinaRepository
    ) {
        return new GetByIdVacinaUseCase(vacinaRepository);
    }

    @Bean
    public GetAllVacinasUseCase getAllVacinas(
            AplicacaoVacinaRepository vacinaRepository
    ) {
        return new GetAllVacinasUseCase(vacinaRepository);
    }

    @Bean
    public AplicacaoVacinaService aplicacaoVacinaService(CreateVacinaUseCase createUseCase, UpdateVacinaUseCase updateUseCase, DeleteVacinaUseCase deleteUseCase, GetByIdVacinaUseCase getByIdUseCase, GetAllVacinasUseCase getAllUseCase) {
        return new AplicacaoVacinaService(
                createUseCase,
                updateUseCase,
                deleteUseCase,
                getByIdUseCase,
                getAllUseCase
        );
    }

}
