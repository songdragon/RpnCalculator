package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.MultiplicationOperator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MultiplicationOperatorTestCase {

    RpnStack stack=new RpnStack();
    MultiplicationOperator multiOp=new MultiplicationOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testMultiOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("2"));
        Operation operation = multiOp.operate(stack);
        assertEquals("stack: 6", stack.toString());
        assertNotNull(operation);
        assertEquals(3, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(2, operation.getNumbers().get(1).getNumber().intValue());
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParameterAddOp() throws InsufficientParametersException {


        multiOp.operate(stack);

    }

    @Test(expected = InsufficientParametersException.class)
    public void testMissTwoParameterAddOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("123"));
        multiOp.operate(stack);

    }
}
