package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;

public abstract class AbstractOperator implements Operator {

    public void operate(RpnStack stack, HistoryOperationStack historyStack) throws InsufficientParametersException{
        doOperation(stack);
        recordToHistory(historyStack);
    }

    protected abstract void recordToHistory(HistoryOperationStack historyStack);

    protected abstract void doOperation(RpnStack stack) throws InsufficientParametersException;

}
