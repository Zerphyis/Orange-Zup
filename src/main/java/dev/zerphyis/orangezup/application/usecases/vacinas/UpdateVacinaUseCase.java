package dev.zerphyis.orangezup.application.usecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.UpdateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;
import dev.zerphyis.orangezup.domain.entities.AplicacaoVacina;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.exception.AplicacaoNotfound;
import dev.zerphyis.orangezup.domain.interfacecases.vacinas.UpdateVacinaInterface;

public class UpdateVacinaUseCase implements UpdateVacinaInterface {
    private final AplicacaoVacinaRepository repository;

    public UpdateVacinaUseCase(AplicacaoVacinaRepository repository) {
        this.repository = repository;
    }

    public VacinaResponse execute(UpdateVacinaRequest input) {

        var existing = repository.findById(input.id())
                .orElseThrow(() -> new AplicacaoNotfound(input.id()));

        AplicacaoVacina updated = new AplicacaoVacina(
                input.nomeVacina(),
                existing.getEmailUsuario(),
                input.dataAplicacao()
        );

        repository.update(updated);

        return new VacinaResponse(
                updated.getNomeVacina(),
                updated.getEmailUsuario(),
                updated.getDataAplicacao()
        );
    }
}
