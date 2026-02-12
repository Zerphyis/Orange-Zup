package dev.zerphyis.orangezup.application.usecases.services;

import dev.zerphyis.orangezup.application.dto.usuarios.CreateUsuarioRequest;
import dev.zerphyis.orangezup.application.dto.usuarios.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.application.usecases.usuarios.*;
import dev.zerphyis.orangezup.domain.entities.Usuario;

import java.util.List;

public class UsuarioService {
    private final CreateUsuarioUseCase createUseCase;
    private final UpdateUsuarioUseCase updateUseCase;
    private final DeleteUsuarioUseCase deleteUseCase;
    private final GetUsuarioCpfUseCase getByCpfUseCase;
    private final ListUsuarioUseCase listUseCase;

    public UsuarioService(
            CreateUsuarioUseCase createUseCase,
            UpdateUsuarioUseCase updateUseCase,
            DeleteUsuarioUseCase deleteUseCase,
            GetUsuarioCpfUseCase getByCpfUseCase,
            ListUsuarioUseCase listUseCase
    ) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.getByCpfUseCase = getByCpfUseCase;
        this.listUseCase = listUseCase;
    }

    public Usuario create(CreateUsuarioRequest request) {
        return createUseCase.execute(request);
    }

    public Usuario update(String cpf, UpdateUsuarioRequest request) {
        return updateUseCase.execute(cpf, request);
    }

    public void delete(String cpf) {
        deleteUseCase.execute(cpf);
    }

    public Usuario findByCpf(String cpf) {
        return getByCpfUseCase.execute(cpf);
    }

    public List<Usuario> findAll() {
        return listUseCase.execute();
    }
}
