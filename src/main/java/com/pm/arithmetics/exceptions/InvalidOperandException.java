package com.pm.arithmetics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown if operand sent by client is invalid
 * e.g. 0 in case of division
 */
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Invalid operand exception")
public class InvalidOperandException extends RuntimeException{

}
