package io.zts.rpn.core.operator;

import static org.junit.Assert.*;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.AdditionOperator;
import org.junit.Before;
import org.junit.Test;

public class AdditionOperatorTestCase {

    RpnStack stack=new RpnStack();
    AdditionOperator addOp=new AdditionOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testAddOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("2"));
        Operation operation = addOp.operate(stack);
        assertEquals("stack: 5", stack.toString());
        assertNotNull(operation);
        assertEquals(3, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(2, operation.getNumbers().get(1).getNumber().intValue());
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParameterAddOp() throws InsufficientParametersException {


        addOp.operate(stack);

    }

    @Test(expected = InsufficientParametersException.class)
    public void testMissTwoParameterAddOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("123"));
        addOp.operate(stack);

    }
}
