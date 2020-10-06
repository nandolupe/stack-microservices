package com.skymicrosystems.chmapi.exceptions;

import lombok.Getter;

@Getter
public class PlayerNotFoundException extends RuntimeException {

  private final String id;

  public PlayerNotFoundException(final String id) {
    super("Jogador nao encontrado, id: " + id);
    this.id = id;
  }

}
