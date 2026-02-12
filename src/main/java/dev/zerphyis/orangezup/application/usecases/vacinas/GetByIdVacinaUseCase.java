package dev.zerphyis.orangezup.application.usecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.exception.AplicacaoNotfound;
import dev.zerphyis.orangezup.domain.interfacecases.vacinas.GetByIdVacinaInterface;

public class GetByIdVacinaUseCase  implements GetByIdVacinaInterface {
    private final AplicacaoVacinaRepository repository;

    public GetByIdVacinaUseCase(AplicacaoVacinaRepository repository) {
        this.repository = repository;
    }

    public VacinaResponse execute(Long id) {

        var aplicacao = repository.findById(id)
                .orElseThrow(() -> new AplicacaoNotfound(id));

        return new VacinaResponse(
                aplicacao.getNomeVacina(),
                aplicacao.getEmailUsuario(),
                aplicacao.getDataAplicacao()
        );
    }
}
