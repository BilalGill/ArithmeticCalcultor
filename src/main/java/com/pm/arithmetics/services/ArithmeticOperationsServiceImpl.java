package com.pm.arithmetics.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;


//TODO unit test for service

@Service
public class ArithmeticOperationsServiceImpl implements ArithmeticOperationsService {

    @Override
    public double add(double[] operandList) {

//        Arrays.stream(operandList).sum();

//        double result = 0.0;
//        for (int i=0;i<operandList.length;i++){
//            result += operandList[i];
//        }

        return Arrays.stream(operandList).sum();
    }

    @Override
    public double subtract(double[] operandList) {

//        double result = operandList[0];
//        for (int i=1;i<operandList.length;i++){
//            result -= operandList[i];
//        }
//
//        return result;

        return Arrays.stream(Arrays.copyOfRange(operandList, 1, operandList.length))
                .reduce(operandList[0], (a,b)->a-b);
    }

    @Override
    public double multiply(double[] operandList) {

//        double result = 1.0;
//        for (int i=0;i<operandList.length;i++){
//            result *= operandList[i];
//        }
//
//        return result;

        return Arrays.stream(operandList).reduce(1, (a,b)->a*b);
    }

    @Override
    public double divide(double[] operandList) {

//        double result = operandList[0];
//        for (int i=0;i<operandList.length;i++){
//            result /= operandList[i];
//        }
//
//        return result;

        return Arrays.stream(Arrays.copyOfRange(operandList, 1, operandList.length))
                .reduce(operandList[0], (a,b)->a/b);
    }
}
