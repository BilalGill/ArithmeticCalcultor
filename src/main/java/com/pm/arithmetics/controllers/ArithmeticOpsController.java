package com.pm.arithmetics.controllers;

import com.pm.arithmetics.services.ArithmeticOpsService;
import com.pm.arithmetics.validators.InputValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;


@RestController
@RequestMapping("v1")
public class ArithmeticOpsController {

    private final ArithmeticOpsService arithmeticOpsService;
    private DecimalFormat df = new DecimalFormat("0.00");

    public ArithmeticOpsController(ArithmeticOpsService arithmeticOpsService) {
        this.arithmeticOpsService = arithmeticOpsService;
    }


    /**
     * This function validate the input and perform addition
     *
     * @param inputList
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestBody double[] inputList) {
        InputValidator.inputValidate(inputList);
        double result = this.arithmeticOpsService.add(inputList);
        return df.format(result);
    }


    /**
     * This function validate the input and perform subtraction
     *
     * @param inputList
     * @return
     */
    @PostMapping("/subtract")
    public String subtract(@RequestBody double[] inputList) {
        InputValidator.inputValidate(inputList);
        double result = this.arithmeticOpsService.subtract(inputList);
        return df.format(result);
    }


    /**
     * This function validate the input and perform multiplication
     *
     * @param inputList
     * @return
     */
    @PostMapping("/multiply")
    public String multiply(@RequestBody double[] inputList) {
        InputValidator.inputValidate(inputList);
        double result = this.arithmeticOpsService.multiply(inputList);
        return df.format(result);
    }


    /**
     * This function validate the input and perform division
     *
     * @param inputList
     * @return
     */
    @PostMapping("/divide")
    public String divide(@RequestBody double[] inputList) {
        InputValidator.inputValidate(inputList);
        InputValidator.dividentValidate(inputList);
        double result = this.arithmeticOpsService.divide(inputList);
        return df.format(result);
    }
}
