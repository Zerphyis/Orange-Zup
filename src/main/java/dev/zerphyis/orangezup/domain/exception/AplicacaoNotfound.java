package dev.zerphyis.orangezup.domain.exception;

public class AplicacaoNotfound extends RuntimeException {
    public AplicacaoNotfound(Long id) {
        super("Aplicação de vacina não encontrada com id: " + id);
    }
}
