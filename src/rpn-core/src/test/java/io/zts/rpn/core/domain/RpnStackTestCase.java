package io.zts.rpn.core.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RpnStackTestCase {

    RpnStack stack=new RpnStack();

    @Before
    public void testBefore(){
        stack.clear();
    }

    @Test
    public void testRpnStackDisplay(){
        stack.push(new RpnOperand("5"));
        assertEquals("stack: 5", stack.toString());
    }

    @Test
    public void testRpnStackDisplayAfterSomeOp(){
        stack.push(new RpnOperand("5"));
        stack.pop();
        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("13"));
        assertEquals("stack: 3 13", stack.toString());
    }
}
