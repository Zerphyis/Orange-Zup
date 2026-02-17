package dev.zerphyis.orangezup.infra.controllers;

import dev.zerphyis.orangezup.application.dto.usuarios.CreateUsuarioRequest;
import dev.zerphyis.orangezup.application.dto.usuarios.UpdateUsuarioRequest;
import dev.zerphyis.orangezup.application.dto.usuarios.UsuarioResponse;
import dev.zerphyis.orangezup.application.usecases.services.UsuarioService;
import dev.zerphyis.orangezup.domain.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@RequestBody @Valid CreateUsuarioRequest request) {
        UsuarioResponse usuarioResponse = service.create(request);
        return ResponseEntity
                .created(URI.create("/api/usuarios/" + usuarioResponse.cpf()))
                .body(usuarioResponse);
    }



    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioResponse> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf));
    }


    @PutMapping("/{cpf}")
    public ResponseEntity<UsuarioResponse> update(
            @PathVariable String cpf,
            @RequestBody @Valid UpdateUsuarioRequest request
    ) {
        return ResponseEntity.ok(service.update(cpf, request));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        service.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
