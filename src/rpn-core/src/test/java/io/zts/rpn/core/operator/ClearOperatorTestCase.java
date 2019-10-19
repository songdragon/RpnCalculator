package io.zts.rpn.core.operator;

import static org.junit.Assert.*;

import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.ClearOperator;
import org.junit.Before;
import org.junit.Test;

public class ClearOperatorTestCase {

    RpnStack stack=new RpnStack();
    ClearOperator clearOperator=new ClearOperator();

    @Before
    public void before(){
        stack.clear();
    }

    @Test
    public void testClear() throws InsufficientParametersException {

        stack.push(new RpnOperand("123"));
        clearOperator.operate(stack);

        assertEquals("stack:",stack.toString());
    }

}
