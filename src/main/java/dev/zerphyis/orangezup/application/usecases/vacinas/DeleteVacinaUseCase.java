package dev.zerphyis.orangezup.application.usecases.vacinas;

import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.exception.AplicacaoNotfound;
import dev.zerphyis.orangezup.domain.interfacecases.vacinas.DeleteVacinaInterface;

public class DeleteVacinaUseCase implements DeleteVacinaInterface {
    private final AplicacaoVacinaRepository repository;

    public DeleteVacinaUseCase(AplicacaoVacinaRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {

        if (!repository.existsById(id)) {
            throw new AplicacaoNotfound(id);
        }

        repository.deleteById(id);
    }
}
