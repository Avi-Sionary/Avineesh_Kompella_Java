package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        if (value2 == 0) { // Division by zero not allowed.
            throw new IllegalArgumentException("Error - cannot divide by zero.");
        }

        return value1 / value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable int value) { // Gracefully handles square that exceeds maximum integer value of 2147483647

        if ((long)value * (long)value > Integer.MAX_VALUE) { // Arithmetic using longs since the max value is HUGE
            throw new IllegalArgumentException("Error - exceeded maximum integer value.");
        }

        return value * value;
    }
}
