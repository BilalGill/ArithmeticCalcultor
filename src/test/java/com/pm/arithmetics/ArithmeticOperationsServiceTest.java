package com.pm.arithmetics;


import com.pm.arithmetics.services.ArithmeticOperationsService;
import com.pm.arithmetics.services.ArithmeticOperationsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class ArithmeticOperationsServiceTest {

    private ArithmeticOperationsService arithmeticOperationsService;

    @BeforeEach
    public void setUp() {
        this.arithmeticOperationsService = new ArithmeticOperationsServiceImpl();
    }

    @Test
    public void additionTest() {

        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(6.0, this.arithmeticOperationsService.add(mockInputList));
    }

    @Test
    public void subtractionTest() {

        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(-4.0, this.arithmeticOperationsService.subtract(mockInputList));
    }

    @Test
    public void mulplicationTest() {

        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(6.0, this.arithmeticOperationsService.multiply(mockInputList));
    }


    @Test
    public void divideTest() {

        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(0.16666666666666666, this.arithmeticOperationsService.divide(mockInputList));
    }

    @Test
    public void divideByZeroTest() {

        double[] mockInputList = {1,0,3};
        Assertions.assertEquals(Infinity, this.arithmeticOperationsService.divide(mockInputList));
    }
}
