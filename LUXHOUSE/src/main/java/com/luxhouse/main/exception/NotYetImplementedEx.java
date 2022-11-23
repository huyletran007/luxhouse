package com.luxhouse.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NotYetImplementedEx extends Exception {

  public NotYetImplementedEx(String message) {
    super(message);
  }
}
