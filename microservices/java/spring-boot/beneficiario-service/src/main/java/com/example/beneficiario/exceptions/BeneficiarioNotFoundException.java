package com.example.beneficiario.exceptions;

import lombok.Getter;

@Getter
public class BeneficiarioNotFoundException extends RuntimeException {

  private final Long id;

  public BeneficiarioNotFoundException(final long id) {
    super("Beneficiario nao encontrado, id: " + id);
    this.id = id;
  }

}
