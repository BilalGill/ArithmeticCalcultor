package com.pm.arithmetics;


import com.pm.arithmetics.services.ArithmeticOpsService;
import com.pm.arithmetics.services.ArithmeticOpsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class ArithmeticOpsServiceTest {

    private ArithmeticOpsService arithmeticOpsService;

    @BeforeEach
    public void setUp() {
        this.arithmeticOpsService = new ArithmeticOpsServiceImpl();
    }

    @Test
    public void doAdditionTest() {
        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(6.0, this.arithmeticOpsService.add(mockInputList));
    }

    @Test
    public void doSubtractionTest() {
        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(-4.0, this.arithmeticOpsService.subtract(mockInputList));
    }

    @Test
    public void doMultiplicationTest() {
        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(6.0, this.arithmeticOpsService.multiply(mockInputList));
    }


    @Test
    public void doDivideTest() {
        double[] mockInputList = {1,2,3};
        Assertions.assertEquals(0.16666666666666666, this.arithmeticOpsService.divide(mockInputList));
    }

    // Division by 0 should return "Infinity" in the arithmetic service
    @Test
    public void doDivideByZeroTest() {
        double[] mockInputList = {1,0,3};
        Assertions.assertEquals(Infinity, this.arithmeticOpsService.divide(mockInputList));
    }
}
