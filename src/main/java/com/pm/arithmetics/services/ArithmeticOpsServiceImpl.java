package com.pm.arithmetics.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;



@Service
public class ArithmeticOpsServiceImpl implements ArithmeticOpsService {

    @Override
    public double add(double[] operandList) {
        return Arrays.stream(operandList).sum();
    }

    @Override
    public double subtract(double[] operandList) {
        return Arrays.stream(Arrays.copyOfRange(operandList, 1, operandList.length))
                .reduce(operandList[0], (a,b)->a-b);
    }

    @Override
    public double multiply(double[] operandList) {
        return Arrays.stream(operandList).reduce(1, (a,b)->a*b);
    }

    @Override
    public double divide(double[] operandList) {
        return Arrays.stream(Arrays.copyOfRange(operandList, 1, operandList.length))
                .reduce(operandList[0], (a,b)->a/b);
    }
}
