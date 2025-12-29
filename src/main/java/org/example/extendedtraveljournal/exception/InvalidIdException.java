package org.example.extendedtraveljournal.exception;

import lombok.Getter;

@Getter
public class InvalidIdException extends RuntimeException {

  public InvalidIdException() {
    super("ID must be a positive value");
  }
}
