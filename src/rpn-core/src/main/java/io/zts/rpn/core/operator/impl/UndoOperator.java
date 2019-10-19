package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;

public class UndoOperator implements Operator {
    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {
        stack.pop();
        return null;
    }
}
