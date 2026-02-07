package dev.zerphyis.orangezup.domain.entities.vo;

import dev.zerphyis.orangezup.domain.exception.InvalidCpfException;

public record Cpf(String value) {

    public Cpf {
        if (value == null) {
            throw new InvalidCpfException("CPF é obrigatório.");
        }

        String normalized = value.replaceAll("\\D", "");

        if (!normalized.matches("\\d{11}")) {
            throw new InvalidCpfException("CPF deve conter 11 dígitos numéricos.");
        }

        if (!isValidCpf(normalized)) {
            throw new InvalidCpfException("CPF inválido.");
        }

        value = normalized;
    }

    private static boolean isValidCpf(String cpf) {
        if (cpf.chars().distinct().count() == 1) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }

        int firstCheck = 11 - (sum % 11);
        firstCheck = (firstCheck >= 10) ? 0 : firstCheck;

        if (firstCheck != (cpf.charAt(9) - '0')) return false;

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }

        int secondCheck = 11 - (sum % 11);
        secondCheck = (secondCheck >= 10) ? 0 : secondCheck;

        return secondCheck == (cpf.charAt(10) - '0');
    }
}
