package dev.zerphyis.orangezup.infra.persistence.repository.adapter;

import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.repository.UsuarioRepository;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.infra.persistence.mapper.UsuarioMapper;
import dev.zerphyis.orangezup.infra.persistence.repository.UsuarioRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {
    private final UsuarioRepositoryJpa jpaRepository;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryAdapter(UsuarioRepositoryJpa jpaRepository, UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        var entity = mapper.toDbEntity(usuario);
        var saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> findByCpf(String cpf) {
        return jpaRepository.findByCpf(cpf)
                .map(mapper::toDomain);
    }

    @Override
    public Optional findByEmail(Email email) {
        return jpaRepository.findByEmail(email);
    }


    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByCpf(String cpf) {
        jpaRepository.deleteByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }
}
