package com.pm.arithmetics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Invalid operand exception")
public class InvalidOperandException extends RuntimeException{

}