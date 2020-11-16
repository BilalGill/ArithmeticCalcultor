package com.pm.arithmetics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown if size of operand list is less 2,
 * because minimum 2 operand are mandatory to perform arithmetic operations
 */
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Not Enough operands")
public class NotEnoughOperandException extends RuntimeException{

}
