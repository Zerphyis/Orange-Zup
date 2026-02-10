package dev.zerphyis.orangezup.infra.persistence.mapper;

import dev.zerphyis.orangezup.domain.entities.AplicacaoVacina;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.infra.persistence.entity.AplicacaoVacinaEntity;
import org.springframework.stereotype.Component;

@Component
public class AplicacaoVacinaMapper {
        public static AplicacaoVacinaEntity toEntity(AplicacaoVacina domain) {
            return new AplicacaoVacinaEntity(
                    null,
                    domain.getNomeVacina(),
                    domain.getEmailUsuario().value(),
                    domain.getDataAplicacao()
            );
        }

        public static AplicacaoVacina toDomain(AplicacaoVacinaEntity entity) {
            return new AplicacaoVacina(
                    entity.getNomeVacina(),
                    new Email(entity.getEmailUsuario()),
                    entity.getDataAplicacao()
            );
        }
    }


