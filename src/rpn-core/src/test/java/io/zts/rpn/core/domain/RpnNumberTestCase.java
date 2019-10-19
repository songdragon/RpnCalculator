package io.zts.rpn.core.domain;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class RpnNumberTestCase {

    @Test
    public void testNullNumber(){
        RpnOperand number=new RpnOperand();
        assertNull(number.getNumber());
        assertEquals("", number.toString());
    }

    @Test
    public void testDisplayNumberNoMoreThan10Decimal(){
        RpnOperand number=new RpnOperand();
        number.setNumber(new BigDecimal(3));
        assertEquals("3", number.toString());
        number.setNumber(new BigDecimal("3.1"));
        assertEquals("3.1",number.toString());
        number.setNumber(new BigDecimal("3.1415926234"));
        assertEquals("3.1415926234",number.toString());
    }

    @Test
    public void testDisplayNumberMoreThan10Decimal(){
        RpnOperand number=new RpnOperand();
        number.setNumber(new BigDecimal(Math.sqrt(2)));
        assertEquals("1.4142135623",number.toString());
    }
}
