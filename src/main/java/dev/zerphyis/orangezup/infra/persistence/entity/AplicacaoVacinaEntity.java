package dev.zerphyis.orangezup.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AplicacaoVacinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_vacina", nullable = false)
    private String nomeVacina;

    @Column(name = "email_usuario", nullable = false)
    private String emailUsuario;

    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;



    public AplicacaoVacinaEntity(
            Long id,
            String nomeVacina,
            String emailUsuario,
            LocalDate dataAplicacao
    ) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.emailUsuario = emailUsuario;
        this.dataAplicacao = dataAplicacao;
    }


}
