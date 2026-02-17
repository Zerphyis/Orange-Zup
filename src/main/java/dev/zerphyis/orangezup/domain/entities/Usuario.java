package dev.zerphyis.orangezup.domain.entities;

import dev.zerphyis.orangezup.domain.entities.vo.Cpf;
import dev.zerphyis.orangezup.domain.entities.vo.Email;
import dev.zerphyis.orangezup.domain.exception.InvalidBirthException;
import dev.zerphyis.orangezup.domain.exception.InvalidNameException;

import java.time.LocalDate;

public class Usuario {
    private Long id;
    private  String nome;
    private  Email email;
    private  Cpf cpf;
    private  LocalDate dataNascimento;

    public Usuario(Long id, String nome, Email email, Cpf cpf, LocalDate dataNascimento) {
        validarNome(nome);
        validarEmail(email);
        validarCpf(cpf);
        validarDataNascimento(dataNascimento);

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(String nome, Email email, Cpf cpf, LocalDate dataNascimento) {
        this(null, nome, email, cpf, dataNascimento);
    }

    public Long getId() {
        return id;
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

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setEmail(Email email) {
        validarEmail(email);
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        validarDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
    }


}
