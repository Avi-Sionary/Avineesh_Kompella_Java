package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    // Division tests
    @Test
    public void shouldDividePositives() {
        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {
        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    // Addition tests
    @Test
    public void shouldAddPositives() {
        assertEquals(7, calc.add(3, 4));
        assertEquals(26, calc.add(13, 13));
        assertEquals(1234, calc.add(1233, 1));
    }

    @Test
    public void shouldAddNegatives() {
        assertEquals(-3, calc.add(-1, -2));
        assertEquals(-25, calc.add(-13, -12));
        assertEquals(-79, calc.add(-54, -25));
    }

    @Test
    public void shouldAddBothPositiveAndNegative() {
        assertEquals(6, calc.add(-3, 9));
        assertEquals(64, calc.add(66, -2));
        assertEquals(-120, calc.add(-500, 380));
    }

    @Test
    public void shouldAddByZero() {
        assertEquals(9, calc.add(9, 0));
        assertEquals(12, calc.add(0, 12));
        assertEquals(23, calc.add(0, 23));
    }

    @Test
    public void shouldAddIntoZero() {
        assertEquals(0, calc.add(0, 0));
        assertEquals(0, calc.add(-100, 100));
        assertEquals(0, calc.add(1, -1));
    }

    // Subtraction tests
    @Test
    public void shouldSubtractPositives() {
        assertEquals(17, calc.subtract(21, 4));
        assertEquals(82, calc.subtract(100, 18));
        assertEquals(50, calc.subtract(51, 1));
    }

    @Test
    public void shouldSubtractNegatives() {
        assertEquals(-12, calc.subtract(-18, -6));
        assertEquals(93, calc.subtract(-7, -100));
        assertEquals(-18, calc.subtract(-30, -12));
    }

    @Test
    public void shouldSubtractBothPositiveAndNegative() {
        assertEquals(-14, calc.subtract(-6, 8));
        assertEquals(24, calc.subtract(9, -15));
        assertEquals(-110, calc.subtract(-96, 14));
    }

    @Test
    public void shouldSubtractByZero() {
        assertEquals(69, calc.subtract(69, 0));
        assertEquals(67, calc.subtract(67, 0));
        assertEquals(987, calc.subtract(987, 0));
    }

    @Test
    public void shouldSubtractFromZero() {
        assertEquals(1, calc.subtract(0, -1));
        assertEquals(-9, calc.subtract(0, 9));
        assertEquals(-49, calc.subtract(0, 49));
    }

    @Test
    public void shouldSubtractIntoZero() {
        assertEquals(0, calc.subtract(0, 0));
        assertEquals(0, calc.subtract(100, 100));
        assertEquals(0, calc.subtract(-1, -1));
    }

    // Multiplication tests
    @Test
    public void shouldMultiplyPositives() {
        assertEquals(63, calc.multiply(7, 9));
        assertEquals(70, calc.multiply(10, 7));
        assertEquals(9, calc.multiply(1, 9));
    }

    @Test
    public void shouldMultiplyNegatives() {
        assertEquals(12, calc.multiply(-6,-2));
        assertEquals(3120, calc.multiply(-80, -39));
        assertEquals(1, calc.multiply(-1, -1));
    }

    @Test
    public void shouldMultiplyBothPosAndNeg() {
        assertEquals(-3, calc.multiply(1,-3));
        assertEquals(-12, calc.multiply(-4, 3));
        assertEquals(-1, calc.multiply(1, -1));
    }

    @Test
    public void shouldMultiplyIntoZero() {
        assertEquals(0, calc.multiply(0,0));
        assertEquals(0, calc.multiply(0, 1));
        assertEquals(0, calc.multiply(105, 0));
    }
}
