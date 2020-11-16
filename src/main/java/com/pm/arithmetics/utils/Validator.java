package com.pm.arithmetics.utils;

import com.pm.arithmetics.exceptions.TooShortOperandException;
import com.pm.arithmetics.exceptions.InvalidZeroOperandForDivisionException;

import java.util.Arrays;

public class Validator {

    public static void inputValidate(double[] operandList) {
        if(operandList.length < 2)
            throw new TooShortOperandException();
    }

    public static void dividentValidate(double[] operandList) {
        if(Arrays.stream(operandList).filter(a->a==0).findAny().isPresent())
            throw new InvalidZeroOperandForDivisionException();
    }
}
