package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnNumber;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;
import io.zts.rpn.core.operator.RpnOperator;

import java.math.MathContext;
import java.math.RoundingMode;

public class DivisionOperator implements Operator {

    protected MathContext mathContext=new MathContext(32,RoundingMode.HALF_EVEN);

    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {
        RpnNumber number2=stack.pop();
        RpnNumber number1=stack.pop();
        if(number1==null || number2==null){
            throw new InsufficientParametersException();
        }

        RpnNumber division=new RpnNumber();

        division.setNumber(number1.getNumber().divide(number2.getNumber(),mathContext));
        stack.push(division);

        return new Operation(RpnOperator.DIVISION,number1,number2);
    }
}
