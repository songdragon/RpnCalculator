package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;

import java.util.List;

public class UndoOperator implements Operator {
    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {
        stack.pop();
        return null;
    }

    public void recoverStack(RpnStack stack, HistoryOperationStack historyStack){
        Operation operation=historyStack.pop();
        if(operation==null){
            return;
        }
        if(operation.getOperator()==null){
            //numbers are push into stack, just pop it

        }
        else {
            //operations with numbers
            List<RpnOperand> numbers = operation.getNumbers();
            if (numbers != null) {
                for (RpnOperand num : numbers) {
                    stack.push(num);
                }
            }
        }
    }
}
