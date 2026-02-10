package dev.zerphyis.orangezup.infra.persistence.repository;

import dev.zerphyis.orangezup.infra.persistence.entity.AplicacaoVacinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AplicacaoVacinaRepositoryJpa extends JpaRepository<AplicacaoVacinaEntity,Long> {
    List<AplicacaoVacinaEntity> findByEmailUsuario(String emailUsuario);
}
