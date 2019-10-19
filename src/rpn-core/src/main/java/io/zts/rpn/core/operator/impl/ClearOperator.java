package io.zts.rpn.core.operator.impl;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.Operator;
import io.zts.rpn.core.operator.RpnOperator;

import java.util.ArrayList;
import java.util.List;

public class ClearOperator implements Operator {

    @Override
    public Operation operate(RpnStack stack) throws InsufficientParametersException {

        List<RpnOperand> numbers=new ArrayList<>(stack.getStack());

        stack.clear();

        return new Operation(RpnOperator.CLEAR,numbers);
    }
}
