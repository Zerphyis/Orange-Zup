package dev.zerphyis.orangezup.domain.entities;

import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidDataAplicacao;
import dev.zerphyis.orangezup.domain.exception.InvalidVacinaException;

import java.time.LocalDate;
import java.util.Objects;

public class AplicacaoVacina {

    private final String nomeVacina;
    private final Email emailUsuario;
    private final LocalDate dataAplicacao;

    public AplicacaoVacina(String nomeVacina, Email emailUsuario, LocalDate dataAplicacao) {
        validarVacina(nomeVacina);
        validarDataAplicacao(dataAplicacao);
        Objects.requireNonNull(emailUsuario, "E-mail do usuário não pode ser nulo");

        this.nomeVacina = nomeVacina;
        this.emailUsuario = emailUsuario;
        this.dataAplicacao = dataAplicacao;
    }


    public void validarVacina(String vacina) {
        if (vacina == null || vacina.trim().isEmpty()) {
            throw new InvalidVacinaException("Nome da vacina não pode ser nulo ou vazio");
        }
    }


    public void validarDataAplicacao(LocalDate dataAplicacao) {
        if (dataAplicacao == null) {
            throw new InvalidDataAplicacao("Data de aplicação não pode ser nula");
        }
    }


    public String getNomeVacina() {
        return nomeVacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public Email getEmailUsuario() {
        return emailUsuario;
    }
}
