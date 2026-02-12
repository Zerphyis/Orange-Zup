package dev.zerphyis.orangezup.application.usecases.vacinas;

import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.interfacecases.vacinas.GetAllVacinaInterface;

import java.util.List;

public class GetAllVacinasUseCase implements GetAllVacinaInterface {
    private final AplicacaoVacinaRepository repository;

    public GetAllVacinasUseCase(AplicacaoVacinaRepository repository) {
        this.repository = repository;
    }

    public List<VacinaResponse> execute() {

        return repository.findAll()
                .stream()
                .map(a -> new VacinaResponse(
                        a.getNomeVacina(),
                        a.getEmailUsuario(),
                        a.getDataAplicacao()
                ))
                .toList();
    }
}
