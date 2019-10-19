package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;
import io.zts.rpn.core.operator.RpnOperator;

import java.math.BigDecimal;

/**
 * calculate SQRT on the top element of stack
 */
public class SqrtOperator implements Operator {
    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {
        RpnOperand num=stack.pop();
        if(num==null){
            throw new InsufficientParametersException(RpnOperator.SQRT,stack.getStackPos());
        }
        double numInDouble=num.getNumber().doubleValue();
        RpnOperand result=new RpnOperand();
        result.setNumber(new BigDecimal(Math.sqrt(numInDouble)));
        stack.push(result);

        return new Operation(RpnOperator.SQRT,num);
    }
}
