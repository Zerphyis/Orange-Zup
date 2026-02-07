package dev.zerphyis.orangezup.domain.exception;

public class InvalidCpfException extends RuntimeException {
    public InvalidCpfException(String message) {
        super(message);
    }
}
