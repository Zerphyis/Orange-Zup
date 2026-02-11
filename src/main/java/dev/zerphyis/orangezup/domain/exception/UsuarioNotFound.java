package dev.zerphyis.orangezup.domain.exception;

import dev.zerphyis.orangezup.domain.entities.vo.Email;

public class UsuarioNotFound extends RuntimeException {
  public UsuarioNotFound(Email email) {
    super("Usuário não encontrado com email: " + email);
  }
}
