package com.pm.arithmetics.controllers;

import com.pm.arithmetics.services.ArithmeticOperationsService;
import com.pm.arithmetics.utils.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;


@RestController
@RequestMapping("v1")
public class ArithmeticOperationsController {

    private final ArithmeticOperationsService arithmeticService;
    private DecimalFormat df = new DecimalFormat("0.00");

    public ArithmeticOperationsController(ArithmeticOperationsService arithmeticService) {

        this.arithmeticService = arithmeticService;
    }


    @PostMapping("/add")
    public String add(@RequestBody double[] inputList) {

        Validator.inputValidate(inputList);
        double result = this.arithmeticService.add(inputList);
        return df.format(result);
    }

    @PostMapping("/subtract")
    public String subtract(@RequestBody double[] inputList) {

        Validator.inputValidate(inputList);
        double result = this.arithmeticService.subtract(inputList);
        return df.format(result);
    }


    @PostMapping("/multiply")
    public String multiply(@RequestBody double[] inputList) {

        Validator.inputValidate(inputList);
        double result = this.arithmeticService.multiply(inputList);
        return df.format(result);
    }


    @PostMapping("/divide")
    public String divide(@RequestBody double[] inputList) {

        Validator.inputValidate(inputList);
        Validator.dividentValidate(inputList);
        double result = this.arithmeticService.divide(inputList);
        return df.format(result);
    }
}
