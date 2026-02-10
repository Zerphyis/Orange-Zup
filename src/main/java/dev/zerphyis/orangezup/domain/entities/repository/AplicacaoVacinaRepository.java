package dev.zerphyis.orangezup.domain.entities.repository;

import dev.zerphyis.orangezup.domain.entities.AplicacaoVacina;
import dev.zerphyis.orangezup.domain.entities.vo.Email;

import java.util.List;
import java.util.Optional;

public interface AplicacaoVacinaRepository {
    AplicacaoVacina save(AplicacaoVacina aplicacaoVacina);

    Optional<AplicacaoVacina> findById(Long id);

    List<AplicacaoVacina> findAll();

    List<AplicacaoVacina> findByEmailUsuario(Email email);

    AplicacaoVacina update(AplicacaoVacina aplicacaoVacina);

    void deleteById(Long id);

    boolean existsById(Long id);

}
