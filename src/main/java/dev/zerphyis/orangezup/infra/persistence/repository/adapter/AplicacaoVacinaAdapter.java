package dev.zerphyis.orangezup.infra.persistence.repository.adapter;

import dev.zerphyis.orangezup.domain.entities.AplicacaoVacina;
import dev.zerphyis.orangezup.domain.entities.repository.AplicacaoVacinaRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.infra.persistence.mapper.AplicacaoVacinaMapper;
import dev.zerphyis.orangezup.infra.persistence.repository.AplicacaoVacinaRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AplicacaoVacinaAdapter implements AplicacaoVacinaRepository {
    private final AplicacaoVacinaRepositoryJpa jpaRepository;

    public AplicacaoVacinaAdapter(
            AplicacaoVacinaRepositoryJpa jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public AplicacaoVacina save(AplicacaoVacina aplicacaoVacina) {
        var entity = AplicacaoVacinaMapper.toEntity(aplicacaoVacina);
        var saved = jpaRepository.save(entity);
        return AplicacaoVacinaMapper.toDomain(saved);
    }



    @Override
    public Optional<AplicacaoVacina> findById(Long id) {
        return jpaRepository.findById(id)
                .map(AplicacaoVacinaMapper::toDomain);
    }

    @Override
    public List<AplicacaoVacina> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(AplicacaoVacinaMapper::toDomain)
                .toList();
    }


    @Override
    public List<AplicacaoVacina> findByEmailUsuario(Email email) {
        return jpaRepository.findByEmailUsuario(email.value())
                .stream()
                .map(AplicacaoVacinaMapper::toDomain)
                .toList();
    }

    @Override
    public AplicacaoVacina update(AplicacaoVacina aplicacaoVacina) {
        return save(aplicacaoVacina);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
