package dev.zerphyis.orangezup.infra.persistence.repository;

import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.infra.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByCpf(String cpf);

    Optional<Usuario> findByEmail(Email email);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    void deleteByCpf(String cpf);
}
