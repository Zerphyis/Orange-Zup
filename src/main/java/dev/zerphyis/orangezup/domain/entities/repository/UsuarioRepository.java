package dev.zerphyis.orangezup.domain.entities.repository;

import dev.zerphyis.orangezup.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findAll();

    void deleteByCpf(String cpf);
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
