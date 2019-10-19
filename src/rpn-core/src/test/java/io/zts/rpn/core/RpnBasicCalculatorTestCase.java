package io.zts.rpn.core;

import static org.junit.Assert.*;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import org.junit.Before;
import org.junit.Test;

public class RpnBasicCalculatorTestCase {

    RpnCalculator calculator;

    private String testBasicCalculator(String input) throws InsufficientParametersException {
        return calculator.calculate(input).toString();
    }

    @Before
    public void before(){
        //TODO: reset calculator
        calculator=RpnCalculatorFactory.getBasicInstance();
        calculator.getRpnStack().clear();
    }

    @Test
    public void testExample1() throws InsufficientParametersException {
        String input="5 2";
        assertEquals("stack: 5 2", testBasicCalculator(input));
    }

    @Test
    public void testExample2() throws InsufficientParametersException {
        String input1="2 sqrt";
        assertEquals("stack: 1.4142135623", testBasicCalculator(input1));
        String input2="clear 9 sqrt";
        assertEquals("stack: 3", testBasicCalculator(input2));
    }



    @Test
    public void testExample3() throws InsufficientParametersException {
        String input1="5 2 -";
        assertEquals("stack: 3", testBasicCalculator(input1));
        String input2="3 -";
        assertEquals("stack: 0",testBasicCalculator(input2));
        String input3="clear";
        assertEquals("stack:",testBasicCalculator(input3));
    }

    @Test
    public void testExample4() throws InsufficientParametersException {
        String input1="5 4 3 2";
        assertEquals("stack: 5 4 3 2", testBasicCalculator(input1));
        String input2="undo undo *";
        assertEquals("stack: 20",testBasicCalculator(input2));
        String input3="5 *";
        assertEquals("stack: 100",testBasicCalculator(input3));
        String input4="undo";
        assertEquals("stack: 20 5", testBasicCalculator(input4));
    }

    @Test
    public void testExample5() throws InsufficientParametersException {
        String input1="7 12 2 /";
        assertEquals("stack: 7 6", testBasicCalculator(input1));
        String input2="*";
        assertEquals("stack: 42",testBasicCalculator(input2));
        String input3="4 /";
        assertEquals("stack: 10.5",testBasicCalculator(input3));
    }

    @Test
    public void testExample6() throws InsufficientParametersException {
        String input1="1 2 3 4 5";
        assertEquals("stack: 1 2 3 4 5", testBasicCalculator(input1));
        String input2="*";
        assertEquals("stack: 1 2 3 20",testBasicCalculator(input2));
        String input3="clear 3 4 -";
        assertEquals("stack: -1",testBasicCalculator(input3));
    }

    @Test
    public void testExample7() throws InsufficientParametersException {
        String input1="1 2 3 4 5";
        assertEquals("stack: 1 2 3 4 5", testBasicCalculator(input1));
        String input2="* * * *";
        assertEquals("stack: 120", testBasicCalculator(input2));
    }

    @Test
    public void testExample8() throws InsufficientParametersException {
        String input1="1 2 3 * 5 + * * 6 5";
        try {
            testBasicCalculator(input1);
            fail("Should throw InsufficientParametersException");
        }
        catch (InsufficientParametersException ipe){
            assertEquals("stack: 11",calculator.getRpnStack().toString());
            assertEquals(15,ipe.getPosition());
        }
    }
}
