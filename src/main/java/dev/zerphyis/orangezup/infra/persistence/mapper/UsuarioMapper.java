package dev.zerphyis.orangezup.infra.persistence.mapper;

import dev.zerphyis.orangezup.domain.entities.Usuario;
import dev.zerphyis.orangezup.domain.entities.vo.Cpf;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.infra.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;


@Component
public class UsuarioMapper {


    public UsuarioEntity toDbEntity(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioEntity(
                null,
                usuario.getNome(),
                usuario.getEmail().value(),
                usuario.getCpf().value(),
                usuario.getDataNascimento()
        );
    }

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        return new Usuario(
                entity.getNome(),
                new Email(entity.getEmail()),
                new Cpf(entity.getCpf()),
                entity.getDataNascimento()
        );
    }
}