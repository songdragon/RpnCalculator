package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnNumber;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;
import io.zts.rpn.core.operator.RpnOperator;

/**
 * SubtractionOperation implementation
 */
public class SubtractionOperator implements Operator {

    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {
        RpnNumber number2=stack.pop();
        RpnNumber number1=stack.pop();
        if(number1==null || number2==null){
            int toSub=0;

            if(number2!=null){
                toSub++;
                stack.push(number2);
            }
            if(number1!=null){
                toSub++;
                stack.push(number1);
            }
            throw new InsufficientParametersException(RpnOperator.SUBTRACTION,stack.getStackPos()-toSub);
        }

        RpnNumber sum=new RpnNumber();
        sum.setNumber(number1.getNumber().subtract(number2.getNumber()));
        stack.push(sum);

        return new Operation(RpnOperator.MULTIPLICATION,number1,number2);
    }
}
