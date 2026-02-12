package dev.zerphyis.orangezup.application.usecases.services;

import dev.zerphyis.orangezup.application.dto.vacina.CreateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.UpdateVacinaRequest;
import dev.zerphyis.orangezup.application.dto.vacina.VacinaResponse;
import dev.zerphyis.orangezup.application.usecases.vacinas.*;

import java.util.List;

public class AplicacaoVacinaService {

    private final CreateVacinaUseCase createUseCase;
    private final UpdateVacinaUseCase updateUseCase;
    private final DeleteVacinaUseCase deleteUseCase;
    private final GetByIdVacinaUseCase getByIdUseCase;
    private final GetAllVacinasUseCase getAllUseCase;

    public AplicacaoVacinaService(
            CreateVacinaUseCase createUseCase,
            UpdateVacinaUseCase updateUseCase,
            DeleteVacinaUseCase deleteUseCase,
            GetByIdVacinaUseCase getByIdUseCase,
            GetAllVacinasUseCase getAllUseCase
    ) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.getAllUseCase = getAllUseCase;
    }

    public VacinaResponse create(CreateVacinaRequest request) {
        return createUseCase.execute(request);
    }

    public VacinaResponse update(UpdateVacinaRequest request) {
        return updateUseCase.execute(request);
    }

    public void delete(Long id) {
        deleteUseCase.execute(id);
    }

    public VacinaResponse findById(Long id) {
        return getByIdUseCase.execute(id);
    }

    public List<VacinaResponse> findAll() {
        return getAllUseCase.execute();
    }

}
