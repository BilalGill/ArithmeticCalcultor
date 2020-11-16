package com.pm.arithmetics.validators;

import com.pm.arithmetics.exceptions.NotEnoughOperandException;
import com.pm.arithmetics.exceptions.InvalidOperandException;

import java.util.Arrays;

// This class contain validation functions
public class InputValidator {

    public static void inputValidate(double[] operandList) {
        if(operandList.length < 2)
            throw new NotEnoughOperandException();
    }

    public static void dividentValidate(double[] operandList) {
        if(Arrays.stream(operandList).filter(a->a==0).findAny().isPresent())
            throw new InvalidOperandException();
    }
}
