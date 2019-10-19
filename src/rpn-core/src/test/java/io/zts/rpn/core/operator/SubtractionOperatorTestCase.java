package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnNumber;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.SubtractionOperator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubtractionOperatorTestCase {

    RpnStack stack=new RpnStack();
    SubtractionOperator subOp =new SubtractionOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testSubtractionOp() throws InsufficientParametersException {

        stack.push(new RpnNumber("3"));
        stack.push(new RpnNumber("2"));
        Operation operation = subOp.operate(stack);
        assertEquals("stack: 1", stack.toString());
        assertNotNull(operation);
        assertEquals(3, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(2, operation.getNumbers().get(1).getNumber().intValue());
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParameterAddOp() throws InsufficientParametersException {


        subOp.operate(stack);

    }

    @Test(expected = InsufficientParametersException.class)
    public void testMissTwoParameterAddOp() throws InsufficientParametersException {

        stack.push(new RpnNumber("123"));
        subOp.operate(stack);

    }
}
