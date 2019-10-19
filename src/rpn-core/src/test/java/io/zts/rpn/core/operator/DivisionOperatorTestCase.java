package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.DivisionOperator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DivisionOperatorTestCase {

    RpnStack stack=new RpnStack();
    DivisionOperator divOp =new DivisionOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testDivOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("2"));
        Operation operation = divOp.operate(stack);
        assertEquals("stack: 1.5", stack.toString());
        assertNotNull(operation);
        assertEquals(3, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(2, operation.getNumbers().get(1).getNumber().intValue());
    }

    @Test
    public void testInfiniteDivOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("1"));
        stack.push(new RpnOperand("3"));
        Operation operation = divOp.operate(stack);
        assertEquals("stack: 0.3333333333", stack.toString());
        assertNotNull(operation);
        assertEquals(1, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(3, operation.getNumbers().get(1).getNumber().intValue());
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParameterAddOp() throws InsufficientParametersException {


        divOp.operate(stack);

    }

    @Test(expected = InsufficientParametersException.class)
    public void testMissTwoParameterAddOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("123"));
        divOp.operate(stack);

    }
}
