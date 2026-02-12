package dev.zerphyis.orangezup.application.usecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.CreateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;
import dev.zerphyis.orangezup.domain.entities.AplicacaoVacina;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.exception.UsuarioNotFound;

public class CreateVacinaUseCase {

    private final AplicacaoVacinaRepository vacinaRepository;
    private final UsuarioRepository usuarioRepository;

    public CreateVacinaUseCase(
            AplicacaoVacinaRepository vacinaRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.vacinaRepository = vacinaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public VacinaResponse execute(CreateVacinaRequest request) {

        Usuario usuario = usuarioRepository
                .findByEmail(request.emailUsuario())
                .orElseThrow(() ->
                        new UsuarioNotFound(request.emailUsuario())
                );

        AplicacaoVacina aplicacao = new AplicacaoVacina(
                request.nomeVacina(),
                usuario.getEmail(),
                request.dataAplicacao()
        );

        AplicacaoVacina saved = vacinaRepository.save(aplicacao);

        return new VacinaResponse(
                saved.getNomeVacina(),
                saved.getEmailUsuario(),
                saved.getDataAplicacao()
        );
    }
}
