package com.example.hateoas.person;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {

  private final Long id;

  public PersonNotFoundException(final long id) {
    super("Person could not be found with id: " + id);
    this.id = id;
  }

}
