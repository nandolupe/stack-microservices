package com.skymicrosystems.chmapi.exceptions;

import lombok.Getter;

@Getter
public class SquadNotFoundException extends RuntimeException {

  private final String id;

  public SquadNotFoundException(final String id) {
    super("Clan/Esquadrao nao encontrado, id: " + id);
    this.id = id;
  }

}
