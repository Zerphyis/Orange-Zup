package dev.zerphyis.orangezup.domain.entities;

import dev.zerphyis.orangezup.domain.entities.vo.Cpf;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidBirthException;
import dev.zerphyis.orangezup.domain.exception.InvalidNameException;

import java.time.LocalDate;

public class Usuario {

    private final String nome;
    private final Email email;
    private final Cpf cpf;
    private final LocalDate dataNascimento;

    public Usuario(String nome, Email email, Cpf cpf, LocalDate dataNascimento) {
        validarNome(nome);
        validarEmail(email);
        validarCpf(cpf);
        validarDataNascimento(dataNascimento);

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new InvalidNameException("Nome é obrigatório.");
        }
    }

    private void validarEmail(Email email) {
        if (email == null) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }
    }

    private void validarCpf(Cpf cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }
    }

    private void validarDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new InvalidBirthException("Data de nascimento inválida.");
        }
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
