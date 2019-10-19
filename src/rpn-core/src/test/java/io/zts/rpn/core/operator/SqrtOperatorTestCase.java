package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.SqrtOperator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SqrtOperatorTestCase {

    RpnStack stack=new RpnStack();
    SqrtOperator sqrtOp=new SqrtOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testSqrtOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("2"));
        Operation operation = sqrtOp.operate(stack);
        assertEquals("stack: 3 1.4142135623", stack.toString());
        assertNotNull(operation);
        assertEquals(2, operation.getNumbers().get(0).getNumber().intValue());
        assertEquals(1,operation.getNumbers().size());
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParameterAddOp() throws InsufficientParametersException {


        sqrtOp.operate(stack);

    }

}
