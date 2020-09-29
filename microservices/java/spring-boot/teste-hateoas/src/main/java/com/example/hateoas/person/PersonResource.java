package com.example.hateoas.person;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class PersonResource extends ResourceSupport {

  private final Person person;

  public PersonResource(final Person person) {
    this.person = person;
    final long id = person.getId();
    add(linkTo(PersonController.class).withRel("people"));
    add(linkTo(methodOn(PersonController.class).get(id)).withSelfRel());
  }
}
